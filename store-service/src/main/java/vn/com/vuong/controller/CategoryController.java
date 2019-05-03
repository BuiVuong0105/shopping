package vn.com.vuong.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import vn.com.vuong.constant.HTTPErrorCode;
import vn.com.vuong.entity.Category;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.CategoryRequest;
import vn.com.vuong.request.SearchCategoryRequest;
import vn.com.vuong.response.CategoryResponse;
import vn.com.vuong.service.CategoryService;
import vn.com.vuong.utils.AppUtil;

@RestController
@Slf4j
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/categorys")
	public ResponseEntity<?> search(
			@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "categoryParentId", required = false) Long categoryParentId,
			@RequestParam(name = "order", required = false) Integer order,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		SearchCategoryRequest request = new SearchCategoryRequest(code, name, order, page, size, categoryParentId);
		DataResult<?> result = categoryService.search(request);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	private void getTree(List<Category> listCategory, List<CategoryResponse> listCategoryResponse) {
		for(int i = 0; i < listCategory.size(); i++) {
			Category category = listCategory.get(i);
			CategoryResponse categoryResponse = listCategoryResponse.get(i);
			List<Category> categoryChildrents = category.getCategoryChildrents();
			if(!AppUtil.isCollectionNullOrEmpty(categoryChildrents)) {
				List<CategoryResponse> categoryResponseChildrents = categoryChildrents
						.stream()
						.map(categoryMap -> {
							categoryMap.setCategoryParent(null);
							return new CategoryResponse(categoryMap);
						}).collect(Collectors.toList());
				categoryResponse.setCategoryChildrents(categoryResponseChildrents);
				getTree(categoryChildrents, categoryResponseChildrents);
			}
		}
	}
	
	@GetMapping(value = "/category_tree")
	public ResponseEntity<?> getCategoryTree() {
		List<Category> roots = categoryService.findRootCategory();
		List<CategoryResponse> categoryResponses = new ArrayList<>();
		for (Category root : roots) {
			CategoryResponse categoryResponse = new CategoryResponse(root);
			categoryResponses.add(categoryResponse);
			List<Category> categoryChildrents = root.getCategoryChildrents();
			if(!AppUtil.isCollectionNullOrEmpty(categoryChildrents)) {
				List<CategoryResponse> categoryResponseChildrents = categoryChildrents
						.stream()
						.map(category-> new CategoryResponse(category)).collect(Collectors.toList());
				categoryResponse.setCategoryChildrents(categoryResponseChildrents);
				
				getTree(categoryChildrents, categoryResponseChildrents);
			}
		}
		return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
	}
	
	@GetMapping(value = "/category/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id ) {
		Optional<Category> optionalCategory = categoryService.findById(id);
		Category categoryFindId = optionalCategory.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		return new ResponseEntity<>(new CategoryResponse(categoryFindId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/category")
	public ResponseEntity<?> insert(@RequestBody CategoryRequest request) {
		String code = request.getCode();
		String name = request.getName();
		if(AppUtil.isListObjectNullOrEmpty(code, name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
 		categoryService.findByCode(code).ifPresent(category -> {throw new ApplicationException(HTTPErrorCode.EXIST);});
		try {
			Category category = categoryService.saveOrUpdate(request, null);
			return new ResponseEntity<>(new CategoryResponse(category), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/category/{id}")
	public ResponseEntity<?> update(
			@PathVariable("id") Long id ,
			@RequestBody CategoryRequest request) {
		String code = request.getCode();
		String name = request.getName();
		if(AppUtil.isListObjectNullOrEmpty(code, name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		Category category = categoryService.findById(id).orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		categoryService.findByName(name).ifPresent(present -> {
			if(id.longValue() != present.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		try {
			category = categoryService.saveOrUpdate(request, category);
			return new ResponseEntity<>(new CategoryResponse(category), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/category/{id}")
	public ResponseEntity<?> delete(@PathVariable("") Long id ) {
		Optional<Category> optionalCategory = categoryService.findById(id);
		Category categoryFindId = optionalCategory.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		try {
			categoryService.delete(categoryFindId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
}

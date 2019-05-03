package vn.com.vuong.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import vn.com.vuong.constant.Constant;
import vn.com.vuong.entity.Category;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.repository.CategoryRepository;
import vn.com.vuong.request.CategoryRequest;
import vn.com.vuong.request.SearchCategoryRequest;
import vn.com.vuong.response.CategoryResponse;
import vn.com.vuong.service.CategoryService;

@Repository
public class CategoryServiceImpl extends AbstractBaseService implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public DataResult<List<CategoryResponse>> search(SearchCategoryRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long categoryParentId = request.getCategoryParentId();
		Integer offset = request.getPage() == null ? Constant.Common.DEFAULT_PAGE : request.getPage();
		Integer size = request.getSize() == null ? Constant.Common.DEFAULT_SIZE : request.getSize();
		Integer order = request.getOrder();
		Sort sort = Sort.by("id");
		if(order == null) {
			sort = sort.ascending();
		}else {
			sort = sort.descending();
		}
		Pageable pageable = PageRequest.of(offset, size, sort);
		Page<Category> pageResult = categoryRepository.search(code, name, categoryParentId, pageable);
		
		List<CategoryResponse> categoryResponses = 
				pageResult.getContent()
				.stream()
				.map(category-> new CategoryResponse(category))
				.collect(Collectors.toList());
		
		return new DataResult<List<CategoryResponse>>(pageResult.getNumber(), pageResult.getTotalPages(), pageResult.getTotalElements(), categoryResponses);
	}
	
	@Override
	public List<Category> findRootCategory() {
		return categoryRepository.findRootCategory();
	}
	
	@Override
	public Optional<Category> findById(long id) {
		return categoryRepository.findById(id);
	}
	
	
	@Override
	public Optional<Category> findByName(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public Optional<Category> findByCode(String code) {
		return categoryRepository.findByCode(code);
	}

	@Override
	public Category saveOrUpdate(CategoryRequest request, Category category) {
		if(category == null) {
			category = new Category(request);
		}else {
			category.setValueFromRequest(request);
		}
		return categoryRepository.save(category);
	}
	
	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}
}

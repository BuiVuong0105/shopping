package vn.com.vuong.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import vn.com.vuong.entity.Product;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.ProductRequest;
import vn.com.vuong.request.SearchProductRequest;
import vn.com.vuong.response.ProductResponse;
import vn.com.vuong.service.CategoryService;
import vn.com.vuong.service.ProductService;
import vn.com.vuong.utils.AppUtil;

@RestController
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/products")
	public ResponseEntity<?> search(@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "categoryId", required = false) Long categoryId,
			@RequestParam(name = "order", required = false) Integer order,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		SearchProductRequest request = new SearchProductRequest(code, name, categoryId, order, page, size);
		DataResult<List<ProductResponse>> dataResult = productService.search(request);
		return new ResponseEntity<>(dataResult, HttpStatus.OK);
	}

	@GetMapping(value = "/product/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Product> optional = productService.findById(id);
		Product product = optional.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		return new ResponseEntity<>(new ProductResponse(product), HttpStatus.OK);
	}

	@PostMapping(value = "/product")
	public ResponseEntity<?> insert(@RequestBody @Validated ProductRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long categoryId = request.getCategoryId();

		if (AppUtil.isListObjectNullOrEmpty(code, name, categoryId)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		productService.findByCode(code).ifPresent(consumer -> {
			throw new ApplicationException(HTTPErrorCode.EXIST);
		});
		productService.findByName(name).ifPresent(consumer -> {
			throw new ApplicationException(HTTPErrorCode.EXIST);
		});

		Category category = categoryService.findById(categoryId).orElseThrow(() -> {
			throw new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		request.setCategory(category);
		try {
			Product product = productService.saveOrUpdate(request, null);
			return new ResponseEntity<>(new ProductResponse(product), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}

	@PutMapping(value = "/product/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Validated ProductRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long categoryId = request.getCategoryId();

		if (AppUtil.isListObjectNullOrEmpty(code, name, categoryId)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}

		Optional<Product> optional = productService.findById(id);

		Product product = optional.orElseThrow(() -> {
			return new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});

		productService.findByCode(code).ifPresent(consumer -> {
			if (id.longValue() != consumer.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		productService.findByName(name).ifPresent(consumer -> {
			if (id.longValue() != consumer.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});

		Category category = categoryService.findById(categoryId).orElseThrow(() -> {
			throw new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		request.setCategory(category);
		try {
			product = productService.saveOrUpdate(request, product);
			return new ResponseEntity<>(new ProductResponse(product), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/product/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Optional<Product> optional = productService.findById(id);
		Product product = optional.orElseThrow(() -> {
			return new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		try {
			productService.delete(product);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

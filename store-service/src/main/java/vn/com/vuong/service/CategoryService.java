package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.Category;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.CategoryRequest;
import vn.com.vuong.request.SearchCategoryRequest;
import vn.com.vuong.response.CategoryResponse;

public interface CategoryService extends BaseService {
	
	DataResult<List<CategoryResponse>> search(SearchCategoryRequest request);
	
	List<Category> findRootCategory();
	
	Optional<Category> findById(long id);
	
	Optional<Category> findByName(String name);
	
	Optional<Category> findByCode(String code);
	
	Category saveOrUpdate(CategoryRequest request, Category category);
	
	void delete(Category category);
}

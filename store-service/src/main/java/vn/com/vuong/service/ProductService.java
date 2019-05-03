package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.Product;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.ProductRequest;
import vn.com.vuong.request.SearchProductRequest;
import vn.com.vuong.response.ProductResponse;

public interface ProductService extends BaseService {

	DataResult<List<ProductResponse>> search(SearchProductRequest request);
	
	Optional<Product> findById(long id);
	
	Optional<Product> findByCode(String code);
	
	Optional<Product> findByName(String name);
	
	Product saveOrUpdate(ProductRequest request, Product product);
	
	Product save(Product product);
	
	void delete(Product product);
}

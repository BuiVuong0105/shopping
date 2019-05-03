package vn.com.vuong.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.com.vuong.constant.Constant;
import vn.com.vuong.entity.Product;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.repository.ProductRepository;
import vn.com.vuong.request.ProductRequest;
import vn.com.vuong.request.SearchProductRequest;
import vn.com.vuong.response.ProductResponse;
import vn.com.vuong.service.ProductService;

@Service
public class ProductServiceImpl extends AbstractBaseService implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public DataResult<List<ProductResponse>> search(SearchProductRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long categoryId = request.getCategoryId();
		Integer offset = request.getPage() == null ? Constant.Common.DEFAULT_PAGE : request.getPage();
		Integer size = request.getSize() == null ? Constant.Common.DEFAULT_SIZE : request.getSize();
		Integer order = request.getOrder();
		Sort sort = Sort.by("id");
		if (order == null) {
			sort = sort.ascending();
		} else {
			sort = sort.descending();
		}
		Pageable page = PageRequest.of(offset, size, sort);
		Page<Product> result = productRepository.search(code, name, categoryId, page);
		List<Product> products = result.getContent();
		List<ProductResponse> productResponses = products
				.stream()
				.map(mapper -> new ProductResponse(mapper))
				.collect(Collectors.toList());

		return new DataResult<List<ProductResponse>>(result.getNumber(), result.getTotalPages(), result.getTotalElements(),
				productResponses);
	}

	@Override
	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}

	@Override
	public Optional<Product> findByCode(String code) {
		return productRepository.findByCode(code);
	}

	@Override
	public Optional<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public Product saveOrUpdate(ProductRequest request, Product product) {
		if (product == null) {
			product = new Product(request);
		} else {
			product.setValueFromRequest(request);
		}
		return productRepository.save(product);
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}
}

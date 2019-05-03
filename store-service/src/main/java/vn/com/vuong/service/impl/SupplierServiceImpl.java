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
import vn.com.vuong.entity.Supplier;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.repository.SupplierRepository;
import vn.com.vuong.request.SearchSupplierRequest;
import vn.com.vuong.request.SupplierRequest;
import vn.com.vuong.response.SupplierResponse;
import vn.com.vuong.service.SupplierService;

@Service
public class SupplierServiceImpl extends AbstractBaseService implements SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public DataResult<List<SupplierResponse>> search(SearchSupplierRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Integer offset = request.getPage() == null ? Constant.Common.DEFAULT_PAGE : request.getPage();
		Integer size = request.getSize() == null ? Constant.Common.DEFAULT_SIZE : request.getSize();
		Integer order = request.getOrder();
		Sort sort = Sort.by("id");
		if(order == null) {
			sort = sort.ascending();
		}else {
			sort = sort.descending();
		}
		Pageable page = PageRequest.of(offset, size, sort);
		Page<Supplier> result = supplierRepository.search(code, name, page);
		List<Supplier> listSupplier = result.getContent();
		List<SupplierResponse> lisSupplierResponses = listSupplier
				.stream()
				.map(mapper -> new SupplierResponse(mapper))
				.collect(Collectors.toList());
		return new DataResult<List<SupplierResponse>>(result.getNumber(), result.getTotalPages(), result.getTotalElements(), lisSupplierResponses);
	}

	@Override
	public Optional<Supplier> findById(long id) {
		return supplierRepository.findById(id);
	}

	@Override
	public Optional<Supplier> findByCode(String code) {
		return supplierRepository.findByCode(code);
	}

	@Override
	public Optional<Supplier> findByName(String name) {
		return supplierRepository.findByCode(name);
	}

	@Override
	public Optional<Supplier> findByNameOrCode(String name, String code) {
		return supplierRepository.findByNameOrCode(name, code);
	}

	@Override
	public Supplier saveOrUpdate(SupplierRequest request, Supplier supplier) {
		if(supplier == null) {
			supplier = new Supplier(request);
		}else {
			supplier.setValueFromRequest(request);
		}
		return supplierRepository.save(supplier);
	}

	@Override
	public void delete(Supplier supplier) {
		supplierRepository.delete(supplier);
	}
}

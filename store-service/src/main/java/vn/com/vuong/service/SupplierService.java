package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.Supplier;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.SearchSupplierRequest;
import vn.com.vuong.request.SupplierRequest;
import vn.com.vuong.response.SupplierResponse;

public interface SupplierService extends BaseService {

	DataResult<List<SupplierResponse>> search(SearchSupplierRequest request);
	
	Optional<Supplier> findById(long id);
	
	Optional<Supplier> findByCode(String code);
	
	Optional<Supplier> findByName(String name);
	
	Optional<Supplier> findByNameOrCode(String name, String code);
	
	Supplier saveOrUpdate(SupplierRequest request, Supplier supplier);
	
	void delete(Supplier supplier);
	
}

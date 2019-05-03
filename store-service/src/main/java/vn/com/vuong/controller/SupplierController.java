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
import vn.com.vuong.entity.Supplier;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.SearchSupplierRequest;
import vn.com.vuong.request.SupplierRequest;
import vn.com.vuong.response.SupplierResponse;
import vn.com.vuong.service.SupplierService;
import vn.com.vuong.utils.AppUtil;

@RestController
@Slf4j
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = "/suppliers")
	public ResponseEntity<?> search(
			@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "order", required = false) Integer order,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		SearchSupplierRequest request = new SearchSupplierRequest(code, name, order, page, size);
		DataResult<List<SupplierResponse>> dataResult = supplierService.search(request);
		return new ResponseEntity<>(dataResult, HttpStatus.OK);
	}
	
	@GetMapping(value = "/supplier/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id ) {
		Optional<Supplier> optionalSupplier = supplierService.findById(id);
		Supplier supplier = optionalSupplier.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		return new ResponseEntity<>(new SupplierResponse(supplier), HttpStatus.OK);
	}
	
	@PostMapping(value = "/supplier")
	public ResponseEntity<?> insert(@RequestBody @Validated SupplierRequest request) {
		String code = request.getCode();
		String name = request.getName();
		if(AppUtil.isListObjectNullOrEmpty(code, name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		supplierService.findByNameOrCode(name, code).ifPresent(supplier -> {throw new ApplicationException(HTTPErrorCode.EXIST);});
		try {
			Supplier supplier = supplierService.saveOrUpdate(request, null);
			return new ResponseEntity<>(new SupplierResponse(supplier), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/supplier/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id , @RequestBody @Validated SupplierRequest request) {
		String code = request.getCode();
		String name = request.getName();
		if(AppUtil.isListObjectNullOrEmpty(code, name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		Optional<Supplier> optionalSupplier = supplierService.findById(id);
		Supplier supplier = optionalSupplier.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		supplierService.findByNameOrCode(name, code).ifPresent(supplierConsumer -> {
			if(id.longValue() != supplierConsumer.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		try {
			 supplier = supplierService.saveOrUpdate(request, supplier);
			return new ResponseEntity<>(new SupplierResponse(supplier), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/supplier/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id ) {
		Optional<Supplier> optionalSupplier = supplierService.findById(id);
		Supplier supplier = optionalSupplier.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		try {
			supplierService.delete(supplier);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

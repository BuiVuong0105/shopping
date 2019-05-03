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
import vn.com.vuong.entity.WareHouse;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.SearchWareHouseRequest;
import vn.com.vuong.request.WareHouseRequest;
import vn.com.vuong.response.WareHouseResponse;
import vn.com.vuong.service.WareHouseService;
import vn.com.vuong.utils.AppUtil;

@RestController
@Slf4j
public class WareHouseController {
	
	@Autowired
	private WareHouseService wareHouseService;
	
	@GetMapping(value = "/warehouses")
	public ResponseEntity<?> search(
			@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "order", required = false) Integer order,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		SearchWareHouseRequest request = new SearchWareHouseRequest(code, name, order, page, size);
		DataResult<List<WareHouseResponse>> dataResult = wareHouseService.search(request);
		return new ResponseEntity<>(dataResult, HttpStatus.OK);
	}
	
	@GetMapping(value = "/warehouse/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id ) {
		Optional<WareHouse> optionalWareHouse = wareHouseService.findById(id);
		WareHouse wareHouseFindId = optionalWareHouse.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		WareHouseResponse wareHouseResponse = new WareHouseResponse(wareHouseFindId);
		return new ResponseEntity<>(wareHouseResponse, HttpStatus.OK);
	}
	
	@PostMapping(value = "/warehouse")
	public ResponseEntity<?> insert(@RequestBody @Validated WareHouseRequest wareHouseRequest) {
		String code = wareHouseRequest.getCode();
		String name = wareHouseRequest.getName();
		if(AppUtil.isListObjectNullOrEmpty(code, name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		wareHouseService.findByName(name).ifPresent(wareHouse -> {throw new ApplicationException(HTTPErrorCode.EXIST);});
		wareHouseService.findByCode(code).ifPresent(wareHouse -> {throw new ApplicationException(HTTPErrorCode.EXIST);});
		try {
			WareHouse wareHouse = wareHouseService.saveOrUpdate(wareHouseRequest, null);
			return new ResponseEntity<>(new WareHouseResponse(wareHouse), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/warehouse/{id}")
	public ResponseEntity<?> update(
			@PathVariable("id") Long id ,
			@RequestBody @Validated WareHouseRequest wareHouseRequest) {
		String code = wareHouseRequest.getCode();
		String name = wareHouseRequest.getName();
		if(AppUtil.isListObjectNullOrEmpty(code,name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		Optional<WareHouse> optionalWareHouse = wareHouseService.findById(id);
		WareHouse wareHouseFindId = optionalWareHouse.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		
		wareHouseService.findByName(name).ifPresent(wareHouse -> {
			if(id.longValue() != wareHouse.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		
		wareHouseService.findByCode(code).ifPresent(wareHouse -> {
			if(id.longValue() != wareHouse.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		try {
			WareHouse wareHouse = wareHouseService.saveOrUpdate(wareHouseRequest, wareHouseFindId);
			return new ResponseEntity<>(new WareHouseResponse(wareHouse), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/warehouse/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id ) {
		Optional<WareHouse> optionalWareHouse = wareHouseService.findById(id);
		WareHouse wareHouseFindId = optionalWareHouse.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		try {
			wareHouseService.delete(wareHouseFindId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
}

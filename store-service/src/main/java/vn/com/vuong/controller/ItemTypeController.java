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
import vn.com.vuong.entity.ItemType;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.ItemTypeRequest;
import vn.com.vuong.request.SearchItemTypeRequest;
import vn.com.vuong.response.ItemTypeResponse;
import vn.com.vuong.service.ItemTypeService;
import vn.com.vuong.utils.AppUtil;

@RestController
@Slf4j
public class ItemTypeController {
	
	@Autowired
	private ItemTypeService itemTypeService;
	
	@GetMapping(value = "/item_types")
	public ResponseEntity<?> search(
			@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "order", required = false) Integer order,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		SearchItemTypeRequest request = new SearchItemTypeRequest(code, name, order, page, size);
		DataResult<List<ItemTypeResponse>> dataResult = itemTypeService.search(request);
		return new ResponseEntity<>(dataResult, HttpStatus.OK);
	}
	
	@GetMapping(value = "/item_type/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id ) {
		Optional<ItemType> optionalItemType = itemTypeService.findById(id);
		ItemType itemTypeFindId = optionalItemType.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		return new ResponseEntity<>(new ItemTypeResponse(itemTypeFindId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/item_type")
	public ResponseEntity<?> insert(@RequestBody @Validated ItemTypeRequest request) {
		String code = request.getCode();
		String name = request.getName();
		if(AppUtil.isListObjectNullOrEmpty(code, name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		itemTypeService.findByName(name).ifPresent(itemType -> {throw new ApplicationException(HTTPErrorCode.EXIST);});
		itemTypeService.findByCode(code).ifPresent(itemType -> {throw new ApplicationException(HTTPErrorCode.EXIST);});
		try {
			ItemType itemType = itemTypeService.saveOrUpdate(request, null);
			return new ResponseEntity<>(new ItemTypeResponse(itemType), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/item_type/{id}")
	public ResponseEntity<?> update(
			@PathVariable("id") Long id ,
			@RequestBody ItemTypeRequest request) {
		String code = request.getCode();
		String name = request.getName();
		if(AppUtil.isListObjectNullOrEmpty(code,name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		Optional<ItemType> optional = itemTypeService.findById(id);
		ItemType itemTypeFindId = optional.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		itemTypeService.findByName(name).ifPresent(itemType -> {
			if(id.longValue() != itemType.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		itemTypeService.findByCode(name).ifPresent(itemType -> {
			if(id.longValue() != itemType.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		try {
			ItemType itemType = itemTypeService.saveOrUpdate(request, itemTypeFindId);
			return new ResponseEntity<>(new ItemTypeResponse(itemType), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/item_type/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id ) {
		Optional<ItemType> optionalItemType = itemTypeService.findById(id);
		ItemType itemTypeFindId = optionalItemType.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		try {
			itemTypeService.delete(itemTypeFindId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

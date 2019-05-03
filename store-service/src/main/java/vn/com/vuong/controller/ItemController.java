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
import vn.com.vuong.entity.Item;
import vn.com.vuong.entity.ItemSubType;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.ItemRequest;
import vn.com.vuong.request.SearchItemRequest;
import vn.com.vuong.response.ItemResponse;
import vn.com.vuong.service.ItemService;
import vn.com.vuong.service.ItemSubTypeService;
import vn.com.vuong.utils.AppUtil;

@RestController
@Slf4j
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemSubTypeService itemSubTypeService;
	
	@GetMapping(value = "/item")
	public ResponseEntity<?> search(
			@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "itemTypeId", required = false) Long itemTypeId,
			@RequestParam(name = "order", required = false) Integer order,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		SearchItemRequest request = new SearchItemRequest(code, name, itemTypeId, order, page, size);
		DataResult<List<ItemResponse>> dataResult = itemService.search(request);
		return new ResponseEntity<>(dataResult, HttpStatus.OK);
	}
	
	@GetMapping(value = "/item/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id ) {
		Optional<Item> optionalItem = itemService.findById(id);
		Item item = optionalItem.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		return new ResponseEntity<>(new ItemResponse(item), HttpStatus.OK);
	}
	
	@PostMapping(value = "/item")
	public ResponseEntity<?> insert(@RequestBody @Validated ItemRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long itemSubTypeId = request.getItemSubTypeId();
		
		if(AppUtil.isListObjectNullOrEmpty(code, name, itemSubTypeId)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		itemService.findByCode(code).ifPresent(itemConsumer -> {
			throw new ApplicationException(HTTPErrorCode.EXIST);
		});
		itemService.findByName(name).ifPresent(itemConsumer -> {
			throw new ApplicationException(HTTPErrorCode.EXIST);
		});
		
		ItemSubType itemSubType = itemSubTypeService.findById(itemSubTypeId).orElseThrow(()->{
			throw new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		request.setItemSubType(itemSubType);
		try {
			Item item = itemService.saveOrUpdate(request, null);
			return new ResponseEntity<>(new ItemResponse(item), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/item/{id}")
	public ResponseEntity<?> update(
			@PathVariable("id") Long id ,
			@RequestBody @Validated ItemRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long itemSubTypeId = request.getItemSubTypeId();
		
		if(AppUtil.isListObjectNullOrEmpty(code, name, itemSubTypeId)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		
		Optional<Item> optionalItem = itemService.findById(id);
		Item item = optionalItem.orElseThrow(() -> {
			return new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		
		itemService.findByName(name).ifPresent(itemConsumer -> {
			if(id.longValue() != itemConsumer.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		itemService.findByCode(code).ifPresent(itemConsumer -> {
			if(id.longValue() != itemConsumer.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		
		ItemSubType itemSubType = itemSubTypeService.findById(itemSubTypeId).orElseThrow(()->{
			throw new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		
		
		request.setItemSubType(itemSubType);
		
		try {
			item = itemService.saveOrUpdate(request, item);
			return new ResponseEntity<>(new ItemResponse(item), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/item/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id ) {
		Optional<Item> optionalItem = itemService.findById(id);
		Item item = optionalItem.orElseThrow(() -> {
			return new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		try {
			itemService.delete(item);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

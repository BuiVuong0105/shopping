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
import vn.com.vuong.entity.ItemSubType;
import vn.com.vuong.entity.ItemType;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.ItemSubTypeRequest;
import vn.com.vuong.request.SearchItemSubTypeRequest;
import vn.com.vuong.response.ItemSubTypeResponse;
import vn.com.vuong.service.ItemSubTypeService;
import vn.com.vuong.service.ItemTypeService;
import vn.com.vuong.utils.AppUtil;

@RestController
@Slf4j
public class ItemSubTypeController {

	@Autowired
	private ItemTypeService itemTypeService;

	@Autowired
	private ItemSubTypeService itemSubTypeService;

	@GetMapping(value = "/item_sub_types")
	public ResponseEntity<?> search(@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "itemTypeId", required = false) Long itemTypeId,
			@RequestParam(name = "order", required = false) Integer order,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		SearchItemSubTypeRequest request = new SearchItemSubTypeRequest(code, name, itemTypeId, order, page, size);
		DataResult<List<ItemSubTypeResponse>> dataResult = itemSubTypeService.search(request);
		return new ResponseEntity<>(dataResult, HttpStatus.OK);
	}

	@GetMapping(value = "/item_sub_type/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<ItemSubType> optionalItemSubType = itemSubTypeService.findById(id);
		ItemSubType itemSubType = optionalItemSubType
				.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		return new ResponseEntity<>(new ItemSubTypeResponse(itemSubType), HttpStatus.OK);
	}

	@PostMapping(value = "/item_sub_type")
	public ResponseEntity<?> insert(@RequestBody @Validated ItemSubTypeRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long itemTypeId = request.getItemTypeId();

		if (AppUtil.isListObjectNullOrEmpty(code, name, itemTypeId)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		itemSubTypeService.findByCode(code).ifPresent(itemSubTypeConsumer -> {
			throw new ApplicationException(HTTPErrorCode.EXIST);
		});
		itemSubTypeService.findByName(name).ifPresent(itemSubTypeConsumer -> {
			throw new ApplicationException(HTTPErrorCode.EXIST);
		});

		ItemType itemType = itemTypeService.findById(itemTypeId).orElseThrow(() -> {
			throw new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		request.setItemType(itemType);
		try {
			ItemSubType itemSubType = itemSubTypeService.saveOrUpdate(request, null);
			return new ResponseEntity<>(new ItemSubTypeResponse(itemSubType), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}

	@PutMapping(value = "/item_sub_type/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Validated ItemSubTypeRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long itemTypeId = request.getItemTypeId();

		if (AppUtil.isListObjectNullOrEmpty(code, name, itemTypeId)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}

		Optional<ItemSubType> optionalItemSubType = itemSubTypeService.findById(id);
		ItemSubType itemSubType = optionalItemSubType.orElseThrow(() -> {
			return new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});

		itemSubTypeService.findByCode(code).ifPresent(itemSubTypeConsumer -> {
			if (id.longValue() != itemSubTypeConsumer.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		itemSubTypeService.findByName(name).ifPresent(itemSubTypeConsumer -> {
			if (id.longValue() != itemSubTypeConsumer.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});

		ItemType itemType = itemTypeService.findById(itemTypeId).orElseThrow(() -> {
			throw new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		request.setItemType(itemType);
		try {
			itemSubType = itemSubTypeService.saveOrUpdate(request, itemSubType);
			return new ResponseEntity<>(new ItemSubTypeResponse(itemSubType), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/item_sub_type/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Optional<ItemSubType> optionalItemSubType = itemSubTypeService.findById(id);
		ItemSubType itemSubType = optionalItemSubType.orElseThrow(() -> {
			return new ApplicationException(HTTPErrorCode.NOT_FOUND);
		});
		try {
			itemSubTypeService.delete(itemSubType);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

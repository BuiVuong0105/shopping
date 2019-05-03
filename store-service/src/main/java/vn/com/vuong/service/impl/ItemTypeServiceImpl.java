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
import vn.com.vuong.entity.ItemType;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.repository.ItemTypeRepository;
import vn.com.vuong.request.ItemTypeRequest;
import vn.com.vuong.request.SearchItemTypeRequest;
import vn.com.vuong.response.ItemTypeResponse;
import vn.com.vuong.service.ItemTypeService;

@Service
public class ItemTypeServiceImpl extends AbstractBaseService implements ItemTypeService {

	@Autowired
	private ItemTypeRepository itemTypeRepository;
	
	@Override
	public DataResult<List<ItemTypeResponse>> search(SearchItemTypeRequest request) {
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
		Page<ItemType> result = itemTypeRepository.search(code, name, page);
		List<ItemType> listItemType = result.getContent();
		List<ItemTypeResponse> itemTypeResponses = listItemType
				.stream()
				.map(mapper -> new ItemTypeResponse(mapper))
				.collect(Collectors.toList());
		
		return new DataResult<List<ItemTypeResponse>>(result.getNumber(), result.getTotalPages(), result.getTotalElements(), itemTypeResponses);
	
	}

	@Override
	public Optional<ItemType> findById(long id) {
		return itemTypeRepository.findById(id);
	}

	@Override
	public Optional<ItemType> findByCode(String code) {
		return itemTypeRepository.findByCode(code);
	}

	@Override
	public Optional<ItemType> findByName(String name) {
		return itemTypeRepository.findByName(name);
	}

	@Override
	public ItemType saveOrUpdate(ItemTypeRequest request, ItemType itemType) {
		if(itemType == null) {
			itemType = new ItemType(request);
		}else {
			itemType.setValueFromRequest(request);
		}
		return itemTypeRepository.save(itemType);
	}
	
	@Override
	public ItemType save(ItemType itemType) {
		return itemTypeRepository.save(itemType);
	}

	@Override
	public void delete(ItemType itemType) {
		itemTypeRepository.delete(itemType);
	}
}

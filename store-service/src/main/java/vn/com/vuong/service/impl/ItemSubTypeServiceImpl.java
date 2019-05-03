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
import vn.com.vuong.entity.ItemSubType;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.repository.ItemSubTypeRepository;
import vn.com.vuong.request.ItemSubTypeRequest;
import vn.com.vuong.request.SearchItemSubTypeRequest;
import vn.com.vuong.response.ItemSubTypeResponse;
import vn.com.vuong.service.ItemSubTypeService;

@Service
public class ItemSubTypeServiceImpl extends AbstractBaseService implements ItemSubTypeService {

	@Autowired
	private ItemSubTypeRepository itemSubTypeRepository;

	@Override
	public DataResult<List<ItemSubTypeResponse>> search(SearchItemSubTypeRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long itemTypeId = request.getItemTypeId();
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
		Page<ItemSubType> result = itemSubTypeRepository.search(code, name, itemTypeId, page);
		List<ItemSubType> itemSubTypes = result.getContent();
		List<ItemSubTypeResponse> itemSubTypeResponses = itemSubTypes
				.stream()
				.map(mapper -> new ItemSubTypeResponse(mapper))
				.collect(Collectors.toList());

		return new DataResult<List<ItemSubTypeResponse>>(result.getNumber(), result.getTotalPages(),
				result.getTotalElements(), itemSubTypeResponses);
	}

	@Override
	public Optional<ItemSubType> findById(long id) {
		return itemSubTypeRepository.findById(id);
	}

	@Override
	public Optional<ItemSubType> findByCode(String code) {
		return itemSubTypeRepository.findByCode(code);
	}

	@Override
	public Optional<ItemSubType> findByName(String name) {
		return itemSubTypeRepository.findByName(name);
	}

	@Override
	public ItemSubType saveOrUpdate(ItemSubTypeRequest request, ItemSubType itemSubType) {
		if (itemSubType == null) {
			itemSubType = new ItemSubType(request);
		} else {
			itemSubType.setValueFromRequest(request);
		}
		return itemSubTypeRepository.save(itemSubType);
	}

	@Override
	public void delete(ItemSubType itemSubType) {
		itemSubTypeRepository.delete(itemSubType);
	}

}

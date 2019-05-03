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
import vn.com.vuong.entity.Item;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.repository.ItemRepository;
import vn.com.vuong.request.ItemRequest;
import vn.com.vuong.request.SearchItemRequest;
import vn.com.vuong.response.ItemResponse;
import vn.com.vuong.service.ItemService;

@Service
public class ItemServiceImpl extends AbstractBaseService implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public DataResult<List<ItemResponse>> search(SearchItemRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long itemSubTypeId = request.getItemSubTypeId();
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
		Page<Item> result = itemRepository.search(code, name, itemSubTypeId, page);
		List<Item> listItem = result.getContent();
		List<ItemResponse> itemResponses = listItem.stream().map(mapper -> new ItemResponse(mapper))
				.collect(Collectors.toList());

		return new DataResult<List<ItemResponse>>(result.getNumber(), result.getTotalPages(), result.getTotalElements(),
				itemResponses);
	}

	@Override
	public Optional<Item> findById(long id) {
		return itemRepository.findById(id);
	}

	@Override
	public Optional<Item> findByCode(String code) {
		return itemRepository.findByCode(code);
	}

	@Override
	public Optional<Item> findByName(String name) {
		return itemRepository.findByName(name);
	}

	@Override
	public Item saveOrUpdate(ItemRequest request, Item item) {
		if (item == null) {
			item = new Item(request);
		} else {
			item.setValueFromRequest(request);
		}
		return itemRepository.save(item);
	}

	@Override
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void delete(Item item) {
		itemRepository.delete(item);
	}

}

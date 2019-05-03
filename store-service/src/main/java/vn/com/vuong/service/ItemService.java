package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.Item;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.ItemRequest;
import vn.com.vuong.request.SearchItemRequest;
import vn.com.vuong.response.ItemResponse;

public interface ItemService extends BaseService {
	
	DataResult<List<ItemResponse>> search(SearchItemRequest request);
	
	Optional<Item> findById(long id);
	
	Optional<Item> findByCode(String code);
	
	Optional<Item> findByName(String name);
	
	Item saveOrUpdate(ItemRequest request, Item item);
	
	Item save(Item item);
	
	void delete(Item item);
}

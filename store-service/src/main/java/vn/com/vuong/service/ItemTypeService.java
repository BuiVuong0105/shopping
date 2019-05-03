package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.ItemType;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.ItemTypeRequest;
import vn.com.vuong.request.SearchItemTypeRequest;
import vn.com.vuong.response.ItemTypeResponse;

public interface ItemTypeService extends BaseService {
	
	DataResult<List<ItemTypeResponse>> search(SearchItemTypeRequest request);
	
	Optional<ItemType> findById(long id);
	
	Optional<ItemType> findByCode(String code);
	
	Optional<ItemType> findByName(String name);
	
	ItemType saveOrUpdate(ItemTypeRequest request, ItemType itemType);
	
	ItemType save(ItemType itemType);
	
	void delete(ItemType itemType);
}

package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.ItemSubType;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.ItemSubTypeRequest;
import vn.com.vuong.request.SearchItemSubTypeRequest;
import vn.com.vuong.response.ItemSubTypeResponse;

public interface ItemSubTypeService extends BaseService {
	
	DataResult<List<ItemSubTypeResponse>> search(SearchItemSubTypeRequest request);

	Optional<ItemSubType> findById(long id);

	Optional<ItemSubType> findByCode(String code);

	Optional<ItemSubType> findByName(String name);

	ItemSubType saveOrUpdate(ItemSubTypeRequest request, ItemSubType itemSubType);

	void delete(ItemSubType itemSubType);
}

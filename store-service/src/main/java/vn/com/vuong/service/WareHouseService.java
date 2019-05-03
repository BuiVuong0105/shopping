package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.WareHouse;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.SearchWareHouseRequest;
import vn.com.vuong.request.WareHouseRequest;
import vn.com.vuong.response.WareHouseResponse;

public interface WareHouseService extends BaseService {
	
	DataResult<List<WareHouseResponse>> search(SearchWareHouseRequest request);
	
	Optional<WareHouse> findById(long id);
	
	Optional<WareHouse> findByCode(String code);
	
	Optional<WareHouse> findByName(String name);
	
	WareHouse saveOrUpdate(WareHouseRequest request, WareHouse wareHouse);
	
	void delete(WareHouse wareHouse);
}

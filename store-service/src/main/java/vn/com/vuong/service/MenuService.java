package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.Menu;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.MenuRequest;
import vn.com.vuong.request.SearchMenuRequest;
import vn.com.vuong.response.MenuResponse;

public interface MenuService extends BaseService {
	
	DataResult<List<MenuResponse>> search(SearchMenuRequest request);

	List<Menu> findRootMenu();

	Optional<Menu> findById(long id);

	Optional<Menu> findByName(String name);

	Optional<Menu> findByCode(String code);

	Menu saveOrUpdate(MenuRequest request, Menu menu);
	
	Menu saveOrUpdate(Menu menu);

	void delete(Menu menu);
}

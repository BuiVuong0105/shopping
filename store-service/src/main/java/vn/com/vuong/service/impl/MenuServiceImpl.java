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
import vn.com.vuong.entity.Menu;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.repository.MenuRepository;
import vn.com.vuong.request.MenuRequest;
import vn.com.vuong.request.SearchMenuRequest;
import vn.com.vuong.response.MenuResponse;
import vn.com.vuong.service.MenuService;

@Service
public class MenuServiceImpl extends AbstractBaseService implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public DataResult<List<MenuResponse>> search(SearchMenuRequest request) {
		String code = request.getCode();
		String name = request.getName();
		Long parentId = request.getParentId();
		Integer offset = request.getPage() == null ? Constant.Common.DEFAULT_PAGE : request.getPage();
		Integer size = request.getSize() == null ? Constant.Common.DEFAULT_SIZE : request.getSize();
		Integer order = request.getOrder();
		Sort sort = Sort.by("id");
		if(order == null) {
			sort = sort.ascending();
		}else {
			sort = sort.descending();
		}
		Pageable pageable = PageRequest.of(offset, size, sort);
		Page<Menu> pageResult = menuRepository.search(code, name, parentId, pageable);
		
		List<MenuResponse> menuResponses = 
				pageResult.getContent()
				.stream()
				.map(menu-> new MenuResponse(menu))
				.collect(Collectors.toList());
		
		return new DataResult<List<MenuResponse>>(pageResult.getNumber(), pageResult.getTotalPages(), pageResult.getTotalElements(), menuResponses);
	}

	@Override
	public List<Menu> findRootMenu() {
		return menuRepository.findRootMenu();
	}

	@Override
	public Optional<Menu> findById(long id) {
		return menuRepository.findById(id);
	}

	@Override
	public Optional<Menu> findByName(String name) {
		return menuRepository.findByName(name);
	}

	@Override
	public Optional<Menu> findByCode(String code) {
		return menuRepository.findByCode(code);
	}

	@Override
	public Menu saveOrUpdate(MenuRequest request, Menu menu) {
		if(menu == null) {
			menu = new Menu(request);
		}else {
			menu.setValueFromRequest(request);
		}
		return menuRepository.save(menu);
	}

	@Override
	public Menu saveOrUpdate(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	public void delete(Menu menu) {
		menuRepository.delete(menu);
	}

}

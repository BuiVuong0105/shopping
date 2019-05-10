package vn.com.vuong.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import vn.com.vuong.entity.Menu;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.request.MenuRequest;
import vn.com.vuong.request.SearchMenuRequest;
import vn.com.vuong.response.MenuResponse;
import vn.com.vuong.service.MenuService;
import vn.com.vuong.utils.AppUtil;

@RestController
@Slf4j
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping(value = "/menus")
	public ResponseEntity<?> search(@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "parentId", required = false) Long parentId,
			@RequestParam(name = "order", required = false) Integer order,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		SearchMenuRequest request = new SearchMenuRequest(code, name, order, page, size, parentId);
		DataResult<?> result = menuService.search(request);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/menu_tree")
	public ResponseEntity<?> getMenuTree() {
		List<Menu> roots = menuService.findRootMenu();
		List<MenuResponse> menuResponses = new ArrayList<>();
		
		for (Menu root : roots) {
			MenuResponse menuResponse = new MenuResponse(root);
			menuResponses.add(menuResponse);
			List<Menu> childrents = root.getChildrents();
			
			if(!AppUtil.isCollectionNullOrEmpty(childrents)) {
				List<MenuResponse> responseChildrent = childrents.
						stream()
						.map(childrent-> new MenuResponse(childrent))
						.collect(Collectors.toList());
				
				menuResponse.setChildrents(responseChildrent);
				getTree(childrents, responseChildrent);
			}
		}
		
		return new ResponseEntity<List<MenuResponse>>(menuResponses, HttpStatus.OK);
	}

	private void getTree(List<Menu> childrents, List<MenuResponse> responseChildrent) {
		for(int i = 0; i < childrents.size(); i++) {
			Menu menu = childrents.get(i);
			MenuResponse menuResponse = responseChildrent.get(i);
			List<Menu> listMenu = menu.getChildrents();
			if(!AppUtil.isCollectionNullOrEmpty(listMenu)) {
				List<MenuResponse> menuResponseChildrents = listMenu
						.stream()
						.map(mapper -> {
							mapper.setParent(null);
							return new MenuResponse(mapper);
						}).collect(Collectors.toList());
				menuResponse.setChildrents(menuResponseChildrents);
				getTree(listMenu, menuResponseChildrents);
			}
		}
	}
	
	@GetMapping(value = "/menu/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id ) {
		Optional<Menu> optional = menuService.findById(id);
		Menu menu = optional.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		return new ResponseEntity<>(new MenuResponse(menu), HttpStatus.OK);
	}
	
	@PostMapping(value = "/menu")
	public ResponseEntity<?> insert(@RequestBody MenuRequest request) {
		String code = request.getCode();
		String name = request.getName();
		if(AppUtil.isListObjectNullOrEmpty(code, name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
 		menuService.findByCode(code).ifPresent(menu -> {throw new ApplicationException(HTTPErrorCode.EXIST);});
		try {
			Menu menu = menuService.saveOrUpdate(request, null);
			return new ResponseEntity<>(new MenuResponse(menu), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/menu/{id}")
	public ResponseEntity<?> update(
			@PathVariable("id") Long id ,
			@RequestBody MenuRequest request) {
		String code = request.getCode();
		String name = request.getName();
		if(AppUtil.isListObjectNullOrEmpty(code, name)) {
			throw new ApplicationException(HTTPErrorCode.INVALID_PARAMETER);
		}
		Menu menu = menuService.findById(id).orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		menuService.findByName(name).ifPresent(present -> {
			if(id.longValue() != present.getId().longValue()) {
				throw new ApplicationException(HTTPErrorCode.EXIST);
			}
		});
		try {
			menu = menuService.saveOrUpdate(request, menu);
			return new ResponseEntity<>(new MenuResponse(menu), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/menu/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id ) {
		Optional<Menu> optional = menuService.findById(id);
		Menu menu = optional.orElseThrow(() -> new ApplicationException(HTTPErrorCode.NOT_FOUND));
		try {
			menuService.delete(menu);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ApplicationException(HTTPErrorCode.SERVER_ERROR);
		}
	}

}

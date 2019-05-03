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
import vn.com.vuong.entity.WareHouse;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.repository.WareHouseRepository;
import vn.com.vuong.request.SearchWareHouseRequest;
import vn.com.vuong.request.WareHouseRequest;
import vn.com.vuong.response.WareHouseResponse;
import vn.com.vuong.service.WareHouseService;

@Service("wareHouseService")
public class WareHouseServiceImpl extends AbstractBaseService implements WareHouseService {
	
	@Autowired
	private WareHouseRepository wareHouseRepository;

	@Override
	public DataResult<List<WareHouseResponse>> search(SearchWareHouseRequest request) {
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
		Page<WareHouse> result = wareHouseRepository.search(code, name, page);
		List<WareHouse> listWareHoue = result.getContent();
		List<WareHouseResponse> wareHouseResponses = listWareHoue
				.stream()
				.map(mapper -> new WareHouseResponse(mapper))
				.collect(Collectors.toList());
		return new DataResult<List<WareHouseResponse>>(result.getNumber(), result.getTotalPages(), result.getTotalElements(), wareHouseResponses);
	}
	
	@Override
	public Optional<WareHouse> findById(long id) {
		return wareHouseRepository.findById(id);
	}

	@Override
	public Optional<WareHouse> findByCode(String code) {
		return wareHouseRepository.findByCode(code);
	}

	@Override
	public Optional<WareHouse> findByName(String name) {
		return wareHouseRepository.findByName(name);
	}
	
	@Override
	public WareHouse saveOrUpdate(WareHouseRequest request, WareHouse wareHouse) {
		if(wareHouse == null) {
			wareHouse = new WareHouse(request);
		}else {
			wareHouse.setValueFromRequest(request);
		}
		return wareHouseRepository.save(wareHouse);
	}
	
	@Override
	public void delete(WareHouse wareHouse) {
		wareHouseRepository.delete(wareHouse);
	}
}

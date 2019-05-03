package vn.com.vuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.vuong.entity.ItemType;
import vn.com.vuong.entity.WareHouse;
import vn.com.vuong.repository.ItemTypeRepository;
import vn.com.vuong.repository.WareHouseRepository;

@Service
public class BatchService extends AbstractBaseService {
	
	@Autowired
	private ItemTypeRepository itemTypeRepository;
	
	@Autowired
	private WareHouseRepository wareHouseRepository;
	
	public void schedule() {
		List<ItemType> itemTypes = new ArrayList<ItemType>();
		itemTypes.add(new ItemType(null, "01", "01"));
		itemTypes.add(new ItemType(null, "02", "02"));
		itemTypes.add(new ItemType(null, "03", "03"));
		List<WareHouse> wareHouses = new ArrayList<WareHouse>();
		wareHouses.add(new WareHouse(null, "01", "01"));
		wareHouses.add(new WareHouse(null, "02", "03"));
		wareHouses.add(new WareHouse(null, "03", "02"));
		
		for(int i = 0; i<= 3; i++) {
			itemTypeRepository.save(itemTypes.get(i));
			wareHouseRepository.save(wareHouses.get(i));
			flush();
			clear();
			System.out.println(contain(itemTypes.get(i)));
			System.out.println(contain(wareHouses.get(i)));
			System.out.println(">>>>>>>>>>>>>>>>>>> Index: " + i);
		}
	}
	
	public void batchInsert() {
		List<ItemType> itemTypes = new ArrayList<ItemType>();
		
		itemTypes.add(new ItemType(null, "01", "01"));
		itemTypes.add(new ItemType(null, "02", "02"));
		itemTypes.add(new ItemType(null, "03", "03"));
		
		itemTypes.add(new ItemType(null, "04", "04"));
		itemTypes.add(new ItemType(null, "05", "05"));
		itemTypes.add(new ItemType(null, "06", "06"));
		
		itemTypes.add(new ItemType(null, "07", "07"));
		itemTypes.add(new ItemType(null, "08", "08"));
		itemTypes.add(new ItemType(null, "09", "09"));
		
//		itemTypeRepository.save(itemTypes);
	}
}

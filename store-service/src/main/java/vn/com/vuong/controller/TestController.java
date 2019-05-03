package vn.com.vuong.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vuong.entity.ItemType;
import vn.com.vuong.service.ItemTypeService;
import vn.com.vuong.service.impl.BatchService;

@RestController
public class TestController {
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private ItemTypeService itemTypeService;
	
//	@Autowired
//	private MessageSender messageSender;
	
	@GetMapping(value = "/batch")
	public ResponseEntity<?> batch() {
		batchService.batchInsert();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/jms")
	public ResponseEntity<?> jms() {
//		messageSender.sendMessage("noti.queue", new MessageRequest(1, "Bui Van Vuong"));
//		messageSender.sendMessage("noti.topic", new MessageRequest(1, "Bui Van Toan"));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/edit")
	public ResponseEntity<?> edit() {
		ItemType itemType = itemTypeService.findById(75).get();
		itemType.setName(String.valueOf(new Date().getTime()));
		itemTypeService.save(itemType);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

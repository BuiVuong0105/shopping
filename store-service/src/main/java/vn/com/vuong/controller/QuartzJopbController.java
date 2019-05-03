package vn.com.vuong.controller;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vuong.configuration.quartz.model.JobModel;
import vn.com.vuong.configuration.quartz.service.ScheduleService;

@RestController
public class QuartzJopbController {
	
	@Autowired
	private Scheduler scheduler;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping(value = "/add_job")
	public ResponseEntity<?> addJob(@RequestBody JobModel jobModel) throws SchedulerException{
		scheduleService.scheduleJob(jobModel);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/update_job")
	public ResponseEntity<?> updateJob(@RequestBody JobModel jobModel) throws SchedulerException{
		scheduleService.updateJob(jobModel);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/update_trigger/{name}")
	public ResponseEntity<?> updateTrigger(@PathVariable("name") String name) throws SchedulerException{
		SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
				.withDescription("aaa")
				.withIdentity(name, Scheduler.DEFAULT_GROUP)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(5000)
				.withRepeatCount(5))
				.build();
		// Xóa trigger và thay thế 1 trigger mới được liên kết tơi Job mà trigger cũ liên kết
		// trigger mới không cần cùng tên với trigger cũ
		scheduler.rescheduleJob(new TriggerKey(name, Scheduler.DEFAULT_GROUP), simpleTrigger);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/pause_trigger/{name}")
	public ResponseEntity<?> pauseTrigger(@PathVariable("name") String name) throws SchedulerException{
		scheduler.pauseTrigger(new TriggerKey(name, Scheduler.DEFAULT_GROUP));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/resum_trigger/{name}")
	public ResponseEntity<?> resumeTrigger(@PathVariable("name") String name) throws SchedulerException{
		scheduler.resumeTrigger(new TriggerKey(name, Scheduler.DEFAULT_GROUP));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/pause_job/{name}")
	public ResponseEntity<?> pauseJob(@PathVariable("name") String name) throws SchedulerException{
		scheduler.pauseJob(new JobKey(name, Scheduler.DEFAULT_GROUP));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/resum_job/{name}")
	public ResponseEntity<?> resumeJob(@PathVariable("name") String name) throws SchedulerException{
		scheduler.resumeJob(new JobKey(name, Scheduler.DEFAULT_GROUP));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete_job/{name}")
	public ResponseEntity<?> deleteJob(@PathVariable("name") String name) throws SchedulerException{
		scheduler.deleteJob(new JobKey(name, Scheduler.DEFAULT_GROUP));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

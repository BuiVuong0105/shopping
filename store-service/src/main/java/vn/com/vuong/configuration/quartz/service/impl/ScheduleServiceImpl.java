package vn.com.vuong.configuration.quartz.service.impl;

import java.util.Set;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.vuong.configuration.quartz.QuartzProvider;
import vn.com.vuong.configuration.quartz.model.JobModel;
import vn.com.vuong.configuration.quartz.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private Scheduler scheduler;
	
	@Override
	public void scheduleJob(JobModel jobModel) throws SchedulerException {
		JobDetail jobDetail = QuartzProvider.createJobDetail(jobModel);
		Trigger trigger = QuartzProvider.createSimpleTrigger(jobModel);
		scheduler.scheduleJob(jobDetail, trigger);
	}

	@Override
	public void updateJob(JobModel jobModel) throws SchedulerException {
		JobDetail jobDetail = QuartzProvider.createJobDetail(jobModel);
		Trigger trigger = QuartzProvider.createSimpleTrigger(jobModel);
		// Get the names of all the Triggers in the given group.
		Set<TriggerKey> triggerNodes = scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(jobModel.getName()));
        if (triggerNodes != null && triggerNodes.size() > 0) {
            for (TriggerKey triggerNode: triggerNodes) {
                scheduler.unscheduleJob(triggerNode);
            }
        }else {
        	try {
        		//Remove the indicated Trigger from the scheduler. 
        		//If the related job does not have any other triggers, and the job is not durable, then the job will also be deleted.
        		scheduler.unscheduleJob(new TriggerKey(jobModel.getName(), Scheduler.DEFAULT_GROUP));
        		//Delete the identified Job from the Scheduler - and any associated Triggers.
        		scheduler.deleteJob(new JobKey(jobModel.getName(), Scheduler.DEFAULT_GROUP));
        	}catch (Exception e) {
        		e.printStackTrace();
        	}
        }
		scheduler.scheduleJob(jobDetail, trigger);
	}
}

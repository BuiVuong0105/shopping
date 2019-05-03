package vn.com.vuong.configuration.quartz.service;

import org.quartz.SchedulerException;

import vn.com.vuong.configuration.quartz.model.JobModel;

public interface ScheduleService {
	void scheduleJob(JobModel jobModel) throws SchedulerException;
	void updateJob(JobModel jobModel)throws SchedulerException;
}

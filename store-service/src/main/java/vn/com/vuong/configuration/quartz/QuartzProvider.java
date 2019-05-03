package vn.com.vuong.configuration.quartz;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import vn.com.vuong.configuration.quartz.model.JobModel;

@Component
public class QuartzProvider {

	private JobDetail makeJobDetail(Class<? extends Job> jobClass, String description, String groupName) {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(jobClass);
		jobDetailFactoryBean.setDurability(true);
		jobDetailFactoryBean.setName(jobClass.getName());
		jobDetailFactoryBean.setGroup(groupName);
		jobDetailFactoryBean.setDescription(description);
		jobDetailFactoryBean.afterPropertiesSet();
		return jobDetailFactoryBean.getObject();
	}

	public SimpleTrigger makeSimpleTrigger(Class<? extends Job> jobClass, String description, long repeatInterval, String groupName) {
		SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
		simpleTriggerFactoryBean.setJobDetail(makeJobDetail(jobClass, description, groupName));
		simpleTriggerFactoryBean.setRepeatInterval(repeatInterval);
		simpleTriggerFactoryBean.setStartDelay(1000L);
		simpleTriggerFactoryBean.setName(jobClass.getName());
		simpleTriggerFactoryBean.setGroup(groupName);
		simpleTriggerFactoryBean.afterPropertiesSet();
		return simpleTriggerFactoryBean.getObject();
	}

	public CronTrigger makeCronTrigger(Class<? extends Job> jobClass, String description, String cronExpression, String groupName) throws ParseException {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(makeJobDetail(jobClass, description, groupName));
		cronTriggerFactoryBean.setCronExpression(cronExpression);
		cronTriggerFactoryBean.setName(jobClass.getName());
		cronTriggerFactoryBean.setGroup(groupName);
		cronTriggerFactoryBean.afterPropertiesSet();
		return cronTriggerFactoryBean.getObject();
	}

	public SimpleTrigger makeSimpleTriggerDefault(Class<? extends Job> jobClass, String description, long repeatInterval) {
		return makeSimpleTrigger(jobClass, description, repeatInterval, Scheduler.DEFAULT_GROUP);
	}

	public CronTrigger makeCronTriggerDefault(Class<? extends Job> jobClass, String description, String cronExpression) throws ParseException {
		return makeCronTrigger(jobClass, description, cronExpression, Scheduler.DEFAULT_GROUP);
	}

	public static JobDetail createJobDetail(JobModel jobModel) {
		jobModel.setJobClass();
		JobDetailImpl jobDetail = new JobDetailImpl();
		jobDetail.setName(jobModel.getName());
		jobDetail.setDescription(jobModel.getDescription());
		jobDetail.setGroup(Scheduler.DEFAULT_GROUP);
		jobDetail.setJobClass(jobModel.getJobClass());
		jobDetail.setDurability(true);
		jobDetail.setRequestsRecovery(false);
		return jobDetail;
	}

	public static Trigger createSimpleTrigger(JobModel jobModel) {
		SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
				.withDescription(jobModel.getDescription())
				.withIdentity(jobModel.getName(), Scheduler.DEFAULT_GROUP)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(jobModel.getRepeatInterval().intValue())
				.withRepeatCount(jobModel.getRepeatCount() == null ? SimpleTrigger.REPEAT_INDEFINITELY : jobModel.getRepeatCount()))
				.build();
		return simpleTrigger;
	}
}

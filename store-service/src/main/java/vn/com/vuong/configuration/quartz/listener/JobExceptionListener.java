package vn.com.vuong.configuration.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobExceptionListener extends JobListenerSupport {

	private String name;

	public JobExceptionListener(String name) {
		this.name = name;
	}

	public JobExceptionListener() {
		this("ExceptionListener");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		log.debug("Job Was Execute !");
	}
}

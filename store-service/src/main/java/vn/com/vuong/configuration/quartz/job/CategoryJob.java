package vn.com.vuong.configuration.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Component
@Slf4j
public class CategoryJob extends QuartzJobBean {

	public CategoryJob() {
		log.debug("Contruct CategoryJob");
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Execute Category Job success ");
	}

}

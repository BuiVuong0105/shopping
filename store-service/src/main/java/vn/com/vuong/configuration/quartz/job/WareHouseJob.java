package vn.com.vuong.configuration.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Setter
@Component
public class WareHouseJob extends QuartzJobBean {

	public WareHouseJob() {
		System.out.println("Contruct WareHouseJob");
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Execute WareHouse Job success ");
	}
}

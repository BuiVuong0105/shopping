package vn.com.vuong.configuration.quartz;

import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.listeners.JobListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {
	
	@Autowired
	private AutowiringSpringBeanJobFactory autowiringSpringBeanJobFactory;
	
	@Autowired
	private JobListenerSupport jobExceptionListener;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setGlobalJobListeners(jobExceptionListener);
		schedulerFactoryBean.setDataSource(dataSource);
		schedulerFactoryBean.setJobFactory(autowiringSpringBeanJobFactory);
		Properties properties = new Properties();
		properties.put("org.quarzt.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
		schedulerFactoryBean.setQuartzProperties(properties);
		return schedulerFactoryBean;
	}
}

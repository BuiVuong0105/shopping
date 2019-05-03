package vn.com.vuong;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import vn.com.vuong.filter.CorsFilter;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "vn.com.vuong.repository", 
entityManagerFactoryRef = "entityManagerFactory", 
transactionManagerRef = "transactionManager")
public class StoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new CorsFilter());
		registration.addUrlPatterns("/*");
		registration.setOrder(1);
		return registration;
	}
}

package vn.com.vuong.configuration.jms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class JMSConfig {
	
	@Value("${spring.activemq.broker-url}")
	private String url;
	
	@Value("${spring.activemq.usernamel}")
	private String username;
	
	@Value("${spring.activemq.password}")
	private String password;
	
	@Value("${spring.activemq.pool.enabled}")
	private boolean poolEnable;
	
	@Value("${spring.activemq.pool.max-connections}")
	private int maxConnection;
	
	@Value("${spring.activemq.queue-concurrency}")
	private String concurent;
	
	@Value("${spring.activemq.noti.queue}")
	private String notiQueue;
	
	@Value("${spring.activemq.noti.topic}")
	private String notiTopic;
}

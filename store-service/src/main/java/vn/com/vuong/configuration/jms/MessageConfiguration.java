//package vn.com.vuong.configuration.jms;
//
//import java.util.Arrays;
//
//import javax.jms.QueueConnectionFactory;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.pool.PooledConnectionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.jms.support.converter.SimpleMessageConverter;
//
//@Configuration
//@EnableJms
//public class MessageConfiguration {
//	@Autowired
//	private JMSConfig jmsConfig;
//
//	@Autowired
//	private NamingDestinationResolver destinationResolver;
//
//	@Autowired
//	private MessageReceiver messageReceiver;
//
//	@Bean
//	public QueueConnectionFactory connectionFactory() {
//		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//		connectionFactory.setBrokerURL(jmsConfig.getUrl());
//		connectionFactory.setUserName(jmsConfig.getUsername());
//		connectionFactory.setPassword(jmsConfig.getPassword());
//		connectionFactory.setTrustedPackages(Arrays.asList("vn.com.vuong"));
//		connectionFactory.setAlwaysSessionAsync(true);
//
//		PooledConnectionFactory poolConnectionFactory = new PooledConnectionFactory(connectionFactory);
//		poolConnectionFactory.setMaxConnections(jmsConfig.getMaxConnection());
//		return poolConnectionFactory;
//	}
//
//	@Bean
//	public JmsTemplate poolJmsTemplate() {
//		JmsTemplate jmsTemplate = new JmsTemplate();
//		jmsTemplate.setConnectionFactory(connectionFactory());
//		jmsTemplate.setDestinationResolver(destinationResolver);
//		return jmsTemplate;
//	}
//
//	@Bean
//	MessageConverter converter() {
//		return new SimpleMessageConverter();
//	}
//
//	/**
//	 * Cấu hình sử dụng class Listener
//	 * @return
//	 */
////	@Bean
////	public MessageListenerContainer getContainer() {
////		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
////		container.setConnectionFactory(connectionFactory());
////		container.setDestinationName(jmsConfig.getNotiQueue());
////		container.setDestinationResolver(destinationResolver);
////		container.setMessageListener(messageReceiver);
////		return container;
////	}
//
//	/**
//	 * Cấu hình sử dụng cho @JmsListener
//	 * @return
//	 */
//	@Bean
//	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
//		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//		factory.setConnectionFactory(connectionFactory());
//		factory.setConcurrency(jmsConfig.getConcurent());
//		factory.setDestinationResolver(destinationResolver);
////		factory.setPubSubDomain(false);
//		return factory;
//	}
//}

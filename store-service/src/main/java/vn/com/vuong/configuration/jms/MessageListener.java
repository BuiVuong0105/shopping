//package vn.com.vuong.configuration.jms;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//import vn.com.vuong.request.MessageRequest;
//
//@Component
//@Slf4j
//public class MessageListener {
//	@Autowired
//	private MessageConverter messageConverter;
//
//	@JmsListener(destination = "noti.topic")
//	public void receiveMessageTopic(final Message message) throws JMSException {
//		try {
//			MessageRequest messageJMS = (MessageRequest) messageConverter.fromMessage(message);
//			log.debug(messageJMS.toString());
//		} catch (JMSException e) {
//			e.printStackTrace();
//			log.debug(e.getMessage());
//		}
//	}
//	
//	@JmsListener(destination = "noti.queue")
//	public void receiveMessageQueue(final Message message) throws JMSException {
//		try {
//			MessageRequest messageJMS = (MessageRequest) messageConverter.fromMessage(message);
//			log.debug(messageJMS.toString());
//		} catch (JMSException e) {
//			e.printStackTrace();
//			log.debug(e.getMessage());
//		}
//	}
//}

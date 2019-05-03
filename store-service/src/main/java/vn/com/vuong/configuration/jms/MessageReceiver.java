//package vn.com.vuong.configuration.jms;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//import vn.com.vuong.request.MessageRequest;
//
//@Component
//@Slf4j
//public class MessageReceiver implements MessageListener {
//
//	@Autowired
//	private MessageConverter messageConverter;
//
//	@Override
//	public void onMessage(Message message) {
//		try {
//			MessageRequest messageRequest = (MessageRequest) messageConverter.fromMessage(message);
//			log.debug(messageRequest.toString());
//		} catch (JMSException e) {
//			e.printStackTrace();
//			log.debug(e.getMessage());
//		}
//	}
//}

//package vn.com.vuong.configuration.jms;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.ObjectMessage;
//import javax.jms.Session;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.stereotype.Component;
//
//import vn.com.vuong.request.MessageRequest;
//
//@Component
//public class MessageSender {
//	
//	@Autowired
//	private JmsTemplate jmsTemplate;
//
//	public void sendMessage(String destination, MessageRequest messageRequest) {
//		jmsTemplate.send(destination, new MessageCreator() {
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				ObjectMessage objectMessage = session.createObjectMessage(messageRequest);
//				return objectMessage;
//			}
//		});
//	}
//}

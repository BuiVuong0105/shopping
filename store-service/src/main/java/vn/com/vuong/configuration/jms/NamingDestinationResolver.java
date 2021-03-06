//package vn.com.vuong.configuration.jms;
//
//import javax.jms.Destination;
//import javax.jms.JMSException;
//import javax.jms.Session;
//
//import org.springframework.jms.support.destination.DestinationResolver;
//import org.springframework.stereotype.Component;
//
//@Component
//public class NamingDestinationResolver implements DestinationResolver {
//   public Destination resolveDestinationName(Session session, String destinationName, boolean pubSubDomain) throws JMSException {
//      if (destinationName.endsWith("queue")) {
//         return session.createQueue(destinationName);
//      } else if (destinationName.endsWith("topic")) {
//         return session.createTopic(destinationName);
//      }
//      throw new RuntimeException("Naming convention not respected for destination " + destinationName);
//   }
//}

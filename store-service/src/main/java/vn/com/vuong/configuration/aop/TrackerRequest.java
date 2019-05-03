//package vn.com.vuong.configuration.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Aspect
//@Component
//@Slf4j
//public class TrackerRequest {
//	
//	@Pointcut("execution(** vn.com.vuong.controller.**)")
//	public void executeTrack() {
//	}
//	
//	@Around("executeTrack()")
//	public void watchPerformance(ProceedingJoinPoint jp) {
//		try {
//			log.debug("Tracker>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//			jp.proceed();
//		} catch (Throwable e) {
//			
//		}
//	}
//}

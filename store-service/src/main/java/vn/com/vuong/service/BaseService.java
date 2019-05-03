package vn.com.vuong.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BaseService {
	
	void flush();
	
	void clear();
	
	<T> boolean contain(T t);
}

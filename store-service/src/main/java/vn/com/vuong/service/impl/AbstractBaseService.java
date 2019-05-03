package vn.com.vuong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.vuong.repository.BaseRepository;
import vn.com.vuong.service.BaseService;

public abstract class AbstractBaseService implements BaseService {

	@Autowired
	private BaseRepository baseRepository;

	@Override
	public void flush() {
		baseRepository.flush();
	}

	@Override
	public void clear() {
		baseRepository.clear();
	}
	
	@Override
	public <T> boolean contain(T t) {
		return baseRepository.contain(t);
	}
}

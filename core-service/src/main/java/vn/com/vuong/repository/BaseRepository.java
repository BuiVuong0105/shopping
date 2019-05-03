package vn.com.vuong.repository;

import javax.persistence.EntityManager;

public interface BaseRepository{
	
	EntityManager getEntityManager();

	void clear();

	void flush();
	
	<T> boolean contain(T t);
}

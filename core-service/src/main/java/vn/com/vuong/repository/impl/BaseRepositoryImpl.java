package vn.com.vuong.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import vn.com.vuong.repository.BaseRepository;

@Repository
public class BaseRepositoryImpl implements BaseRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void clear() {
		entityManager.clear();
	}

	public void flush() {
		entityManager.flush();
	}

	public <T> boolean contain(T t) {
		return entityManager.contains(t);
	}
}

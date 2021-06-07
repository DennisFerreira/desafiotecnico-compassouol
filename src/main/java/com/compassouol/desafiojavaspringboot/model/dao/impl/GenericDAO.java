package com.compassouol.desafiojavaspringboot.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.compassouol.desafiojavaspringboot.model.dao.IDAO;


@SuppressWarnings("unchecked")
public abstract class GenericDAO<PK, T> implements IDAO<PK, T> {

	private Class<T> clazz;

	@PersistenceContext
	protected EntityManager entityManager;

	public GenericDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void save(T t) {
		entityManager.persist(t);
	}

	@Override
	public void update(T t) {
		entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		entityManager.remove(t);
	}

	@Override
	public T findById(PK pk) {
		return entityManager.find(clazz, pk);
	}
	
	@Override
	public List<T> listAll(){
		Query query = entityManager.createQuery("SELECT e FROM "+clazz.getSimpleName()+" e");
		return query.getResultList();
	}


	@Override
	public List<T> list(String query) {
		return entityManager.createQuery(query).getResultList();
	}
		
	

}

package com.compassouol.desafiojavaspringboot.model.dao;

import java.util.List;

public interface IDAO<PK, T> {

	public void save(T t);

	public void update(T t);

	public void delete(T t);

	public T findById(PK pk);
	
	public List<T> listAll();

	public List<T> list(String query);
	
}

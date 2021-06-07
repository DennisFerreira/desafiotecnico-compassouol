package com.compassouol.desafiojavaspringboot.model.dao;

import java.util.List;

import com.compassouol.desafiojavaspringboot.model.entity.impl.Product;

public interface IProductDAO extends IDAO<String, Product> {
	public List<Product> buscaComParametros(String q, Double minPrice, Double maxPrice);

}

package com.compassouol.desafiojavaspringboot.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compassouol.desafiojavaspringboot.model.entity.impl.Product;

public interface IProductDAO extends JpaRepository<Product, String>{

}

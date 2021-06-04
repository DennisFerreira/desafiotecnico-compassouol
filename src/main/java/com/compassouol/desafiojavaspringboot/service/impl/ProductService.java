package com.compassouol.desafiojavaspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.compassouol.desafiojavaspringboot.exception.RequisicaoInvalidaException;
import com.compassouol.desafiojavaspringboot.model.dao.IProductDAO;
import com.compassouol.desafiojavaspringboot.model.entity.impl.Product;
import com.compassouol.desafiojavaspringboot.service.IProductService;

@Component
public class ProductService implements IProductService {
	
	@Autowired
	private IProductDAO productDAO;

	@Override
	public void salvar(Product product) throws Exception {
		
		if(product == null) 
			throw new RequisicaoInvalidaException("Product não informado.");
		if(product.getName() == null)
			throw new RequisicaoInvalidaException("Atributo \"name\" não informado.");
		if(product.getDescription() == null)
			throw new RequisicaoInvalidaException("Atributo \"description\" não informado.");
		if(product.getPrice() == null)
			throw new RequisicaoInvalidaException("Atributo \"price\" não informado");
		
		productDAO.save(product);
		
	}

}

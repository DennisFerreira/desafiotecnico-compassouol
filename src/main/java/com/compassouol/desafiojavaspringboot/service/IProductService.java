package com.compassouol.desafiojavaspringboot.service;

import java.util.List;

import com.compassouol.desafiojavaspringboot.exception.ProductNaoEncontradoException;
import com.compassouol.desafiojavaspringboot.exception.RequisicaoInvalidaException;
import com.compassouol.desafiojavaspringboot.model.entity.impl.Product;

public interface IProductService {
	
	public void salvar(Product product) throws Exception;
	public void atualizar(String id, Product product) throws Exception;
	public Product listar(String id) throws Exception; 
	public List<Product> listarTodos() throws Exception;
	public void deletar(String id) throws Exception;
	public List<Product> search(String q, Double minPrice, Double maxPrice) throws Exception;
	public Product validarId(String id) throws ProductNaoEncontradoException;
	public void validarProduct(Product product) throws RequisicaoInvalidaException;
}

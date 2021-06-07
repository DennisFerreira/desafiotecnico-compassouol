package com.compassouol.desafiojavaspringboot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.compassouol.desafiojavaspringboot.exception.ProductNaoEncontradoException;
import com.compassouol.desafiojavaspringboot.exception.RequisicaoInvalidaException;
import com.compassouol.desafiojavaspringboot.model.dao.IProductDAO;
import com.compassouol.desafiojavaspringboot.model.entity.impl.Product;
import com.compassouol.desafiojavaspringboot.service.IProductService;

@Component
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	@Override
	@Transactional
	public void salvar(Product product) throws Exception {
		validarProduct(product);
		productDAO.save(product);
	}

	@Override
	@Transactional
	public void atualizar(String id, Product product) throws Exception {
		Product productBd = validarId(id);
		validarProduct(product);

		product.setId(productBd.getId());
		productDAO.update(product);

	}
	
	@Override
	public List<Product> search(String q, Double minPrice, Double maxPrice) throws Exception {

		List<Product> products =  productDAO.buscaComParametros(q, minPrice, maxPrice);
		return products;
	}

	@Override
	public Product listar(String id) throws Exception {
		Product product = validarId(id);
		return product;
	}

	@Override
	public List<Product> listarTodos() throws Exception {
		List<Product> products = productDAO.listAll();

		return products;
	}

	@Override
	@Transactional
	public void deletar(String id) throws Exception {
		Product product = validarId(id);
		productDAO.delete(product);
	}

	@Override
	public Product validarId(String id) throws ProductNaoEncontradoException {
		if (id == null) {
			throw new ProductNaoEncontradoException("Id não identificado");
		}
		Product product = productDAO.findById(id);
		if (product == null) {
			throw new ProductNaoEncontradoException("Product não encontrado");
		}
		return product;
	}

	@Override
	public void validarProduct(Product product) throws RequisicaoInvalidaException {

		if (product == null) {
			throw new RequisicaoInvalidaException("Product não informado.");
		}
		if (product.getName() == null || product.getName().trim().equals("")) {
			throw new RequisicaoInvalidaException("Atributo name não informado.");
		}

		if (product.getDescription() == null || product.getDescription().trim().equals("")) {
			throw new RequisicaoInvalidaException("Atributo description não informado.");
		}
		if (product.getPrice() == null || product.getDescription().trim().equals("")) {
			throw new RequisicaoInvalidaException("Atributo price não informado");
		}
		
		if(product.getPrice() <= 0) {
			throw new RequisicaoInvalidaException("O atributo price deve ser maior que zero");
		}
	}

}

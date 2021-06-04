package com.compassouol.desafiojavaspringboot.resource;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.compassouol.desafiojavaspringboot.exception.RequisicaoInvalidaException;
import com.compassouol.desafiojavaspringboot.model.entity.impl.Product;
import com.compassouol.desafiojavaspringboot.service.IProductService;

@RestController
public class ProductResource {
	
	@Autowired
	private IProductService productService;
	
	
	public ResponseEntity<Product> salvar(Product product) {
		
		try {
			productService.salvar(product);
			return ResponseEntity<Product>(product,HttpStatus.CREATED);
		}catch(RequisicaoInvalidaException e) {
			e.printStackTrace();
			return ;
		}
		
		
	}

}

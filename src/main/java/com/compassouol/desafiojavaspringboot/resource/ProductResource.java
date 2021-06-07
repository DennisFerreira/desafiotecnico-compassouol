package com.compassouol.desafiojavaspringboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compassouol.desafiojavaspringboot.exception.ProductNaoEncontradoException;
import com.compassouol.desafiojavaspringboot.exception.RequisicaoInvalidaException;
import com.compassouol.desafiojavaspringboot.model.entity.impl.Product;
import com.compassouol.desafiojavaspringboot.service.IProductService;
import com.compassouol.desafiojavaspringboot.util.ResponseUtil;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private IProductService productService;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Product product) {

		try {
			productService.salvar(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
		} catch (RequisicaoInvalidaException e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody Product product){
		try {
			productService.atualizar(id, product);
			return ResponseEntity.status(HttpStatus.OK).body(product);
		} catch (RequisicaoInvalidaException e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (ProductNaoEncontradoException e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.NOT_FOUND, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno.");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable String id) {
		try {
			Product product = productService.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(product);
		} catch (ProductNaoEncontradoException e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.NOT_FOUND, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno.");
		}
	}

	@GetMapping
	public ResponseEntity<?> listarTodos() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno.");
		}
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> listarTodos (@RequestParam(value="min_price",required = false) Double minPrice, @RequestParam(value="max_price", required = false) Double maxPrice, @RequestParam(value="q", required = false) String q){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.search(q,minPrice,maxPrice));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno.");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable String id) {
		try {
			productService.deletar(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
			
		} catch (ProductNaoEncontradoException e) {
			return ResponseUtil.status(HttpStatus.NOT_FOUND, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.status(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno.");
		}
	}
	

}

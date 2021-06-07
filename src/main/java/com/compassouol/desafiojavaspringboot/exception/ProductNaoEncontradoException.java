package com.compassouol.desafiojavaspringboot.exception;

public class ProductNaoEncontradoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ProductNaoEncontradoException(String msg){
		super(msg);
	}
}

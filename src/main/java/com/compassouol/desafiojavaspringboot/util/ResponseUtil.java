package com.compassouol.desafiojavaspringboot.util;

import org.springframework.http.HttpStatus;

public class ResponseUtil {
	
	private HttpStatus status_code;
	private String message;
	
	
	public ResponseUtil(HttpStatus status, String message) {
        super();
        this.status_code = status;
        this.message = message;
       
    }

}

package com.compassouol.desafiojavaspringboot.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseUtil {
	
public static ResponseEntity<Map<String, ?>> status(HttpStatus statusCode,String message) {
	    Map<String, Object> errorResponse = new HashMap<>();
	    errorResponse.put("status_code", statusCode.value());
	    errorResponse.put("message", message);
	    return new ResponseEntity<>(errorResponse, statusCode);
	}
}



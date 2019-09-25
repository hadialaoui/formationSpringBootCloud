package com.hadialaoui.spring.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundExeption extends RuntimeException {

	public CustomerNotFoundExeption(String string) {
		super(string);
	}

	
}

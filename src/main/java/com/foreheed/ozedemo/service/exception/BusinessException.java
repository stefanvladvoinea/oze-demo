package com.foreheed.ozedemo.service.exception;

import lombok.Data;

@Data
public abstract class BusinessException extends RuntimeException {
	
	private final Integer code;
	
	public BusinessException(Integer code, String message) {
		super(message);
		this.code = code;
	}

}

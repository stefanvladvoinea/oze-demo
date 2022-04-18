package com.foreheed.ozedemo.service.exception;

public class AuthenticationBusinessException extends BusinessException {

	public AuthenticationBusinessException(String message) {
		super(401, message);
	}

}

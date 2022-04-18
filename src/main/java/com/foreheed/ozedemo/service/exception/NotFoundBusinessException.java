package com.foreheed.ozedemo.service.exception;

public class NotFoundBusinessException extends BusinessException {

	public NotFoundBusinessException(String message) {
		super(404, message);
	}

}

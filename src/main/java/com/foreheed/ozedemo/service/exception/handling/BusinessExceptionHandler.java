package com.foreheed.ozedemo.service.exception.handling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.foreheed.ozedemo.service.exception.BusinessException;
import com.foreheed.ozedemo.service.exception.ExceptionResponse;

@ControllerAdvice
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { BusinessException.class })
	protected ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException exception, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(),
				HttpStatus.valueOf(exception.getCode()));
	}
	
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<ExceptionResponse> handleOtherExceptions(Exception exception, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse("something went wrong");
		return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

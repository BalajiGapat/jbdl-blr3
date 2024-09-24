package com.geek.advice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.geek.dto.ApiError;
import com.geek.exception.ApplicationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleException(ApplicationException e){
		ApiError error= new ApiError(e.getMessage(), 404);
		
		return new ResponseEntity<ApiError>(error, HttpStatusCode.valueOf(404));
	}
}

package com.geek.aspects;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.geek.dto.ApiError;
import com.geek.exceptions.ApplicationException;

@RestControllerAdvice//act as a catch block
public class GlobalExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ApiError> handle(Exception e) {
		ApiError error= new ApiError(e.getMessage());
		return  new ResponseEntity<ApiError>(error, HttpStatusCode.valueOf(404));
	}
}

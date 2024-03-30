package com.exporter.ExporterService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exporter.ExporterService.dto.ErrorResponse;

@ControllerAdvice
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ExporterServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleException(ExporterServiceCustomException exception){
		return new ResponseEntity<>( new ErrorResponse().builder().errorcode(exception.getMessage()).errorcode(exception.getErrorcode()).build(), HttpStatus.NOT_FOUND );
	}
}

package com.curso_erudio.course.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.curso_erudio.course.exceptions.ExceptionResponse;
import com.curso_erudio.course.exceptions.ResourceNotFoundException;

@RestController
@ControllerAdvice
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(),e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handlePersonNotFounException(Exception e, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(),e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	
	
	
}

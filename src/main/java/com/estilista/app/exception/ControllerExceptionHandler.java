package com.estilista.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
	  public ResponseEntity<MensajeException> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		 MensajeException message = new MensajeException(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ "+ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<MensajeException>(message, HttpStatus.NOT_FOUND);
	  }

	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<MensajeException> globalExceptionHandler(Exception ex, WebRequest request) {
		  MensajeException message = new MensajeException(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<MensajeException>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}

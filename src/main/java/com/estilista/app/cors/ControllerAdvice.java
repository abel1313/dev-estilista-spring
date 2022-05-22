package com.estilista.app.cors;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.estilista.app.exception.ErrorIniciar;
import com.estilista.app.model.ErrorMensaje;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
	  @ExceptionHandler(ErrorIniciar.class)
	  public ResponseEntity<ErrorMensaje> resourceNotFoundException(ErrorIniciar ex, WebRequest request) {
		  ErrorMensaje message = new ErrorMensaje(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMensaje>(message, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorMensaje> globalExceptionHandler(Exception ex, WebRequest request) {
		  ErrorMensaje message = new ErrorMensaje(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMensaje>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
	  
	  

}

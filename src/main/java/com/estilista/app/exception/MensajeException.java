package com.estilista.app.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MensajeException {
	
	  private int statusCode;
	  private Date timestamp;
	  private String message;
	  private String description;

}

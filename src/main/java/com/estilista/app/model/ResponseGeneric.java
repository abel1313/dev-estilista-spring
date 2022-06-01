package com.estilista.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param codeValue
 * @param code
 * @param datos
 * */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class ResponseGeneric<T> {
	
	private int codeValue;
	private String code;
	private T datos;
	private String mensaje;

	public ResponseGeneric() {
		this.codeValue = 404;
		this.code = "200 OK";
		this.mensaje = "No se encontro la informacion";
		this.datos = null;
	}
}

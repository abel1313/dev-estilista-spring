package com.estilista.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetalleProductoDto implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String producto;
	private double cantidad;
	private double precio;
	

}

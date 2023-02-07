package com.estilista.app.model;


import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param nombreCorte
 * @param precioTipoCorte
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipoCorte extends SuperClase implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 4265807925337385875L;

	@Column( name = "NOMBRE_CORTE")
	  private String nombreCorte;
	  
	  @Column( name = "PRECIO")
	  private Double precioTipoCorte;
	  
}

package com.estilista.app.model;


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
public class TipoCorte extends SuperClase{

	  @Column( name = "NOMBRE_CORTE")
	  private String nombreCorte;
	  
	  @Column( name = "PRECIO")
	  private Double precioTipoCorte;
	  
}

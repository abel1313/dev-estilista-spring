package com.estilista.app.model;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param tipoPieza
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ruta extends SuperClase{

	  @Column( name = "NOMBRE_RUTAS")
	  private String nombreRuta;
	 
}

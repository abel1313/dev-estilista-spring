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
 * @param precio
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Producto extends SuperClase {

	  @Column( name = "NOMBRE_PRODUCTO")
	  private String nombreProducto;
	  
	  @Column( name = "TIPO_PIEZA_ID")
	  private TamanioProducto tipoPieza;
	  
}

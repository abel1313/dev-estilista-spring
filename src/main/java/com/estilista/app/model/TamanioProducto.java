package com.estilista.app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity
@Table( name = "tamano_productos" )
public class TamanioProducto extends SuperClase{

	  @Column( name = "TIPO_PIEZA")
	  private String tipoPieza;
	  
	  @Column( name = "PRECIO")
	  private Double precio;
	  
	  
}

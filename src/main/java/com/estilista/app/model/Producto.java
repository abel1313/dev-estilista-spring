package com.estilista.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table( name = "PRODUCTOS" )
public class Producto extends SuperClase {

	  @Column( name = "NOMBRE_PRODUCTO")
	  private String nombreProducto;
	  
	  
	  @OneToOne( cascade = CascadeType.ALL)
	  @JoinColumn( name = "TIPO_PIEZA_ID")
	  private TamanioProducto tipoPieza;
	  
}

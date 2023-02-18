package com.estilista.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@NotNull(message = "El nombre no deberica")
	@Column( name = "NOMBRE_PRODUCTO")
	  private String nombreProducto;
	  
	  
	  @OneToOne( cascade = CascadeType.ALL)
	  @JoinColumn( name = "TIPO_PIEZA_ID")
	  private TamanioProducto tamanoProducto;
	  
	  @OneToOne( cascade = CascadeType.ALL)
	  @JoinColumn( name = "ESTATUS_ID")
	  private Estatus estatusPieza;
	  
}

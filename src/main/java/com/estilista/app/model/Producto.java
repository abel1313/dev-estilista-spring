package com.estilista.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

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

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
	@JsonManagedReference
	private List<UploadImagesProducto> listaImagenes;
	  
}

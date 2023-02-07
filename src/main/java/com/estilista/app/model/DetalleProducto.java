package com.estilista.app.model;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param usuarioCita
 * @param clienteCita
 * @param fechaCita
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "DETALLE_PRODUCTO")
public class DetalleProducto extends SuperClase implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column( name = "SUB_TOTAL")
	  private double subTotal;
	  
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JsonBackReference
		@JoinColumn(name = "VENTA_ID")
	  private Venta ventaDetalleProducto;
	  
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JsonBackReference
		@JoinColumn(name = "PRODUCTO_ID")
	  private Producto productoDetalle;
	  
	  @OneToOne
	  @JoinColumn( name = "estatus_id")
	  private Estatus estatus;

	
}

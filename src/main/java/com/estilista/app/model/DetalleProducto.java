package com.estilista.app.model;



import javax.persistence.Column;

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
public class DetalleProducto extends SuperClase{

	  @Column( name = "SUB_TOTAL")
	  private double subTotal;
	  
	  @Column( name = "VENTA_ID")
	  private Venta ventaDetalleProducto;
	  
	  @Column( name = "PRODUCTO_ID")
	  private Producto productoDetalle;

	
}

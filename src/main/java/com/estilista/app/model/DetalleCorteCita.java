package com.estilista.app.model;


import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param subTotal
 * @param venta
 * @param citaDetalleCorte
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetalleCorteCita extends SuperClase{ 

	  @Column( name = "SUB_TOTAL")
	  private double subTotalDetalleCorteCita;
	  
	  @Column( name = "VENTA_ID")
	  private Venta ventaDetalleCorteCita;
	  	  
	  @Column( name = "CITA_ID")
	  private Cita citaDetalleCorteCita;
	  
	
}

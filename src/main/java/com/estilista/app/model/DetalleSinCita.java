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
 * @param ventaDetalleSinCita
 * @param cortePelo
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetalleSinCita extends SuperClase{

	  @Column( name = "SUB_TOTAL")
	  private double subTotal;
	  
	  @Column( name = "VENTA_ID")
	  private Venta ventaDetalleSinCita;
	  
	  @Column( name = "CORTE_PELO_ID")
	  private CortePelo cortePelo;

}

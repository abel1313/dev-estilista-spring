package com.estilista.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param usuarioVenta
 * @param clienteVenta
 * @param totalVenta
 * @param fechaVenta
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta extends SuperClase{

	
			  @Column( name = "USUARIO_ID")
			  @NotNull( message = "Es requerido")
			  private Usuario usuarioVenta;
			  			  
			  @Column( name = "CLIENTE_ID")
			  @NotNull( message = "Es requerido")
			  private Cliente clienteVenta;
			  
			  @Column( name = "TOTAL")
			  @NotNull( message = "Es requerido")
			  private Double totalVenta;
			  
			  
			  @Column( name = "FECHA_VENTA")
			  @NotNull( message = "Es requerido")
			  @Temporal( TemporalType.TIMESTAMP )
			  private Date fechaVenta;
			  
}

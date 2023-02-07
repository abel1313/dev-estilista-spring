package com.estilista.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Entity
@Table( name = "Ventas")
public class Venta extends SuperClase implements Serializable{

	
			  /**
	 * 
	 */
	private static final long serialVersionUID = 8957892102427904602L;

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

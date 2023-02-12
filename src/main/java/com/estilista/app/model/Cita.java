package com.estilista.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "citas")
public class Cita extends SuperClase{

	  @Column( name = "USUARIO_ID")
	  private Usuario usuarioCita;
	  
	  @Column( name = "USUARIO_ID")
	  private Cliente clienteCita;
	  
	  @Temporal( TemporalType.TIMESTAMP)
	  @Column( name = "FECHA_GENERAR_CITA")
	  private Date fechaCita;
}

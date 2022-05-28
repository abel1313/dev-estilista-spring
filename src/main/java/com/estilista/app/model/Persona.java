package com.estilista.app.model;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param nombrePersona
 * @param apeidoPaternoPersona
 * @param apeidoMaternoPersona
 * @param sexo
 * @param fechaNacimientoPersona
 * @param numeroTelefonoPersona
 * @param direccionPersona
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Persona extends SuperClase{

	  @Column( name = "NOMBRE_PERSONA")
	  private String nombrePersona;
	  
	  @Column( name = "PATERNO_PERSONA")
	  private String apeidoPaternoPersona;
	  
	  @Column( name = "MATERNO_PERSONA")
	  private String apeidoMaternoPersona;
	 	  
	  @Column( name = "SEXO_PERSONA")
	  private String sexo;
	  
	  @Column( name = "FECHA_NACIMIENTO_PERSONA")
	  private Date fechaNacimientoPersona;
	  
	  @Column( name = "NUMERO_TELEFONO_PERSONA")
	  private String numeroTelefonoPersona;
	  
	  @Column( name = "DIRECCION_ID")
	  private Direccion direccionPersona;
	
}

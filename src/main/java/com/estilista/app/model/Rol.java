package com.estilista.app.model;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param nombreRol
 * @param usuarioRol
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rol extends SuperClase{
	  
	  @Column( name = "NOMBRE_ROLES")
	  private String nombreRol;
	  
	  @Column( name = "USUARIO_ID")
	  private Usuario usuarioRol;
	  
	  
}

package com.estilista.app.model;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param nombreUsuario
 * @param contrasenaUsuario
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario extends SuperClase{

	
			  			  
			  @Column( name = "NOMBRE_USUARIO")
			  private String nombreUsuario;
			  
			  @Column( name = "CONTRASENA_USUARIO")
			  private String contrasenaUsuario;
			  
			  
}

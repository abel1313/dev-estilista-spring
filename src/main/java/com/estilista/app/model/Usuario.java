package com.estilista.app.model;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Entity
@Table(name = "usuarios")
public class Usuario extends SuperClase implements Serializable{
		  
			  /**
	 * 
	 */
	private static final long serialVersionUID = -382152268906167336L;

			@Column( name = "NOMBRE_USUARIO")
			  private String nombreUsuario;
			  
			  @Column( name = "CONTRASENA_USUARIO")
			  private String contrasenaUsuario;
			  
			  @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarioRol")
			  @JsonManagedReference
			  private Set<Rol> listaRoles;
			  
			  
}

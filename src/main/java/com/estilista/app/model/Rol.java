package com.estilista.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Entity
@Table(name="roles")
public class Rol extends SuperClase implements Serializable{
	  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 6954975536191415728L;

	@Column( name = "NOMBRE_ROLES")
	  private String nombreRol;
	  
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "USUARIO_ID")
	  @JsonBackReference
	  private Usuario usuarioRol;
	  
	  
}

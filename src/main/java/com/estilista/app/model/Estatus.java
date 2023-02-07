package com.estilista.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param activo
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ESTATUS")
public class Estatus extends SuperClase implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private char activo;

}

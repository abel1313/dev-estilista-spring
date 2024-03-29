package com.estilista.app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param estadoDireccion
 * @param municipioDireccion
 * @param calleDireccion
 * @param coloniaDireccion
 * */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "DIRECCIONES")
public class Direccion extends SuperClase{

	  @Column( name = "ESTADO_DIRECCION")
	  @NotNull(message = "El campo es requerido")
	  private String estadoDireccion;
	  
	  @Column( name = "MUNICIPIO_DIRECCION")
	  private String municipioDireccion;
	  
	  @Column( name = "CALLE_DIRECCION")
	  private String calleDireccion;
	  
	  @Column( name = "COLONIA_DIRECCION")
	  private String coloniaDireccion;
	  
	
}

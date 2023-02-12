package com.estilista.app.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param nombreCorte
 * @param precioTipoCorte
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TIPO_CORTE")
public class TipoCorte extends SuperClase implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 4265807925337385875L;

	@Column( name = "NOMBRE_CORTE")
	  private String nombreCorte;
	  
	  @Column( name = "PRECIO")
	  private Double precioTipoCorte;
	  
	  

	  
}

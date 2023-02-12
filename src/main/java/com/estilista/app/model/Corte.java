package com.estilista.app.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param tipoCorte
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CORTES")
public class Corte extends SuperClase{
	  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn( name = "TIPO_CORTE_ID")
	  private TipoCorte tipoCorte;

}

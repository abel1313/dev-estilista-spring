package com.estilista.app.model;



import javax.persistence.Column;

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
public class Corte extends SuperClase{
	  
	  @Column( name = "TIPO_CORTE_ID")
	  private TipoCorte tipoCorte;

}

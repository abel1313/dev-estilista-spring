package com.estilista.app.model;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * @author Abel Tiburcio
 * @param tipoCorte
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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



	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "corteTipo")
	@JsonManagedReference
	private Set<UploadDocumento> listaCortes;

	@Override
	public String toString() {
		return "Corte{" +
				"tipoCorte=" + tipoCorte +
				", listaCortes=" + listaCortes +
				'}';
	}
}

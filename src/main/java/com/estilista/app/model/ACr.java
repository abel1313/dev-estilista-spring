package com.estilista.app.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "acr")
public class ACr extends SuperClase implements Serializable{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1657560335603190024L;

//	@ManyToOne(cascade = CascadeType.ALL)
//
//	@JoinColumn( name = "cr_actividad_id")
//	@JsonBackReference
//	private ACrActividad splo;
	
	@Column(name = "nombreacr")
	private String nombreacr;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "cr_actividad_id")
	private ACrActividad actividad;

}

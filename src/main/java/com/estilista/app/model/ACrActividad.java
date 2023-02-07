package com.estilista.app.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "acr_actividad")
public class ACrActividad extends SuperClase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4332342898008851518L;

	private String nombre;
	
//	@OneToMany( cascade = CascadeType.ALL, mappedBy = "aCrActividad2")
//	@JsonBackReference
//	private List<AAsignacion> listaAss;
	

//	@OneToMany( cascade = CascadeType.ALL, mappedBy = "aCrActividad13")
//	@JsonBackReference
//	private List<ACr> lista;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "cr_actividad_id")
//	@JsonManagedReference
//	private ACrActividad aCrActividad13;
	
//	
//	
//	@OneToMany( cascade = CascadeType.ALL, mappedBy = "lista")
//	@JsonManagedReference
//	private List<ACr> listaA;
	
	
	@OneToMany(cascade =CascadeType.ALL, mappedBy = "actividad")
	@JsonManagedReference
	private Set<ACr> list;
	
//	@OneToMany(cascade =CascadeType.ALL, mappedBy = "asignacion")
//	@JsonManagedReference
//	private List<AAsignacion> listAsig;
	
	
}

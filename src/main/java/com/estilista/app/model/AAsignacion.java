package com.estilista.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "asignacion")
public class AAsignacion extends SuperClase{

	private String nombreAsignacion;
	
//	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonBackReference
//	@JoinColumn(name = "asignacion_id")
//	private AAsignacion asignacion;
//	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "asignacion_id")
//	@JsonManagedReference
//	private ACrActividad aCrActividad2;
	
	
}

package com.estilista.app.dto;



public class ExampleClass {
	
	private String colaborador;
	private String horas;
	private String actividad;
	private String mes;
	
	

	
	
	public ExampleClass() {
	}

	public ExampleClass(String colaborador, String horas, String actividad) {
		super();
		this.colaborador = colaborador;
		this.horas = horas;
		this.actividad = actividad;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	@Override
	public String toString() {
		return "ExampleClass [colaborador=" + colaborador + ", horas=" + horas + ", actividad=" + actividad + "]";
	}

	
}

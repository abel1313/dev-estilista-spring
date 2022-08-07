
package com.estilista.app.model;

public class RegistroActividades {
	
	private int horas;
	private int actividadId;
	private int usuarioId;
	
	
	
	
	public RegistroActividades() {
	}




	public RegistroActividades(int horas, int actividadId, int usuarioId) {
		this.horas = horas;
		this.actividadId = actividadId;
		this.usuarioId = usuarioId;
	}




	public int getHoras() {
		return horas;
	}




	public void setHoras(int horas) {
		this.horas = horas;
	}




	public int getActividadId() {
		return actividadId;
	}




	public void setActividadId(int actividadId) {
		this.actividadId = actividadId;
	}




	public int getUsuarioId() {
		return usuarioId;
	}




	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}




	@Override
	public String toString() {
		return "RegistroActividades [horas=" + horas + ", actividadId=" + actividadId + ", usuarioId=" + usuarioId
				+ "]";
	}

	
}

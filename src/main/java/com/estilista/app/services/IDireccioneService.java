package com.estilista.app.services;

import java.util.List;

import com.estilista.app.model.Direccion;
/**
 * @author Abel Tiburcio
 * 
 * */
public interface IDireccioneService extends IBaseService<Direccion, Integer>{
	
	/**
	 * 
	 * @return List<Direccion>
	 * 
	 * */
	
	public List<Direccion> obtenerTodos();
}

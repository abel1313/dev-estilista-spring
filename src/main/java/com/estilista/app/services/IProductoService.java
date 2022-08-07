package com.estilista.app.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.estilista.app.model.Producto;

public interface IProductoService extends IBaseService<Producto, Integer>{

	public List<Producto> findByNombreProductoContaining(@Param("nombre") String nombre );
	
}

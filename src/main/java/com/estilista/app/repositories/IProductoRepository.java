package com.estilista.app.repositories;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estilista.app.model.Producto;

@Repository
public interface IProductoRepository extends IBaseRepository<Producto, Integer>{
	
	public List<Producto> findByNombreProductoContaining(@Param("nombre") String nombre );

}

package com.estilista.app.services;
/**
 * @author Abel Tiburcio
 * 
 * */

import java.util.List;

import com.estilista.app.dto.DetalleProductoDto;
import com.estilista.app.model.DetalleProducto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface IDetalleProductoService extends IBaseService<DetalleProducto, Integer>{

	public List<DetalleProducto> saveDetalle(@RequestBody final List<DetalleProductoDto> detalleProductoDto) throws Exception;
}

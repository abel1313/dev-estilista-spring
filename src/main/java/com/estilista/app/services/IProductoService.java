package com.estilista.app.services;

import java.util.List;

import com.estilista.app.dto.ProductoImagenesDto;
import com.estilista.app.dto.UploadImagesProductoDto;
import com.estilista.app.model.ResponseGeneric;
import org.hibernate.ResourceClosedException;

import com.estilista.app.model.Producto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProductoService extends IBaseService<Producto, Integer>{

	 List<Producto> findByNombreProductoContaining(@PathVariable("nombre") String nombre );

	 ResponseGeneric<Boolean> saveProductoImage(@RequestBody final Producto producto)throws ResourceClosedException, Exception;
	public ResponseGeneric<Boolean> saveProductoImage(@RequestBody final UploadImagesProductoDto producto) throws Exception;

	ResponseGeneric<List<ProductoImagenesDto>> searchProducts(@PathVariable final int page,
															  @PathVariable final int size) throws Exception;

}

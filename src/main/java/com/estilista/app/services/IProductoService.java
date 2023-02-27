package com.estilista.app.services;

import com.estilista.app.dto.ProductoImagenesDto;
import com.estilista.app.dto.UploadImagesProductoDto;
import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.Producto;
import com.estilista.app.model.ResponseGeneric;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IProductoService extends IBaseService<Producto, Integer>{

	 List<Producto> findByNombreProductoContaining(@PathVariable("nombre") String nombre );
	 ResponseGeneric<Boolean> saveProductoImage(@RequestBody final UploadImagesProductoDto producto) throws ResourceNotFoundException;
	ResponseGeneric<Boolean> updateProductoImage(@RequestBody final UploadImagesProductoDto producto) throws ResourceNotFoundException;

	ResponseGeneric<List<ProductoImagenesDto>> searchProducts(@PathVariable final int page,
															  @PathVariable final int size) throws Exception;


	ResponseGeneric<Optional<ProductoImagenesDto>> findByIdProduct(@PathVariable final int id) throws Exception;

}

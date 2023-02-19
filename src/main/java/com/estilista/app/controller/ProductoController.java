package com.estilista.app.controller;

import java.util.List;

import com.estilista.app.dto.UploadImagesProductoDto;
import com.estilista.app.model.ResponseGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.estilista.app.model.Producto;
import com.estilista.app.service_api.ProductoServiceImp;
import com.estilista.app.services.IProductoService;

@RestController
@RequestMapping("proyecto/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImp>{


	private IProductoService iProductoService;

	@Autowired
	public void setiProductoService(final IProductoService iProductoService) {
		this.iProductoService = iProductoService;
	}

	@GetMapping("/buscarBy/{nombre}")
	public ResponseEntity<List<Producto>>buscarProductos(@PathVariable final String nombre){
		return ResponseEntity.status(HttpStatus.OK).body(iProductoService.findByNombreProductoContaining(nombre));
	}


	@PostMapping("/saveProductoImage")
	public ResponseEntity<ResponseGeneric<Boolean>>buscarProductos(@RequestBody final UploadImagesProductoDto producto) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(iProductoService.saveProductoImage(producto));
	}
}

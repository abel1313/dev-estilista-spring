package com.estilista.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estilista.app.model.Producto;
import com.estilista.app.service_api.ProductoServiceImp;
import com.estilista.app.services.IProductoService;

@RestController
@RequestMapping("proyecto/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImp>{

	@Autowired
	private IProductoService iProductoService;
	
	@GetMapping("/buscarBy/{nombre}")
	public ResponseEntity<List<Producto>>buscarProductos(@PathVariable final String nombre){
		return ResponseEntity.status(HttpStatus.OK).body(iProductoService.findByNombreProductoContaining(nombre));
	}
}

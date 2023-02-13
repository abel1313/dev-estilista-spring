package com.estilista.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilista.app.dto.DetalleProductoDto;
import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.DetalleProducto;
import com.estilista.app.service_api.DetalleProductoServiceImpl;
import com.estilista.app.services.IDetalleProductoService;

@RestController
@RequestMapping("proyecto/detalle-producto")
public class DetalleProductoController extends BaseControllerImpl<DetalleProducto, DetalleProductoServiceImpl>{


	private IDetalleProductoService iDetalleProductoService;
	@Autowired
	public void setiDetalleProductoService(final IDetalleProductoService iDetalleProductoService) {
		this.iDetalleProductoService = iDetalleProductoService;
	}

	@PostMapping("save")
	public ResponseEntity<?> saveDetalle(@RequestBody List<DetalleProductoDto> detalleProductoDto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iDetalleProductoService.saveDetalle(detalleProductoDto));	
		} catch (Exception e2) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResourceNotFoundException(e2.getMessage()));
		}
		

	}
	
}

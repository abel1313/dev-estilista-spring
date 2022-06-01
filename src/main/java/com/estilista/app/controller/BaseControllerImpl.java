package com.estilista.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.SuperClase;
import com.estilista.app.service_api.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class BaseControllerImpl<E extends SuperClase, S extends BaseServiceImpl<E, Integer>>
		implements IBaseController<E, Integer> {

	@Autowired
	protected S service;

	@Override
	@GetMapping("")
	public ResponseEntity<?> getAll() throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.service.getAll() );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{'error':'Error. Verificar ' " + e.getMessage() + " '  '} ");
		}
		
	}

	@Override
	@GetMapping("obtenerDatos")
	public ResponseEntity<?> getAllE() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllE());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable final Integer id) throws Exception {
		ResponseGeneric<E> responseGeneric = new ResponseGeneric<>();
		
		try {
			final Optional<E> e = service.getOne(id);
			if( e.isPresent() ) {
				responseGeneric.setDatos(e.get());
				responseGeneric.setMensaje("Dato encontrado correctamente");
			}else {
				responseGeneric.setDatos(null);
				responseGeneric.setMensaje("El dato que busca no se encontro");
			}
			return ResponseEntity.status(HttpStatus.OK).body(responseGeneric);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
		}
	}

	@Override
	@PostMapping("guardar")
	public ResponseEntity<?> saveE(@Valid @RequestBody E e) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.service.save(e));
		} catch (Exception ee) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
		}
	}

	@Override
	@PostMapping("")
	public ResponseEntity<?> save(@Valid @RequestBody final E e) throws Exception {
		try {

			return ResponseEntity.status(HttpStatus.OK).body( this.service.save(e));
		} catch (Exception ee) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
		}
		
	}

	@Override
	@PutMapping("")
	public ResponseEntity<?> update(@PathVariable final Integer id, @RequestBody final E e) throws Exception {
		// TODO Auto-generated method stub
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, e));
		} catch (Exception es) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error': 'Error. Verifica' } ");
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
		} catch (Exception es) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error': 'Error. Verifica' } ");
		}
	}

	@Override
	@PostMapping("obtenerDatos")
	public ResponseEntity<?> obtenerDatosId(@RequestBody E e) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(service.obtenerPost(e.getId()));

	}

}

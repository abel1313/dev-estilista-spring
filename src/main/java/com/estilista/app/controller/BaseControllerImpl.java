package com.estilista.app.controller;

import javax.validation.Valid;

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
		// TODO Auto-generated method stub
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
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
	public ResponseEntity<?> getOne(@PathVariable Integer id) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
		}
	}

	@Override
	@PostMapping("guardar")
	public ResponseEntity<?> saveE(@Valid @RequestBody E e) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(service.saveE(e));
	}

	@Override
	@PostMapping("")
	public ResponseEntity<?> save(@Valid @RequestBody E e) throws Exception {
		if (e != null) {
			try {
				return ResponseEntity.status(HttpStatus.OK).body(service.save(e));
			} catch (Exception es) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("{'error': 'Error. Verifica ' " + es.getMessage() + " ' } ");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
	}

	@Override
	@PutMapping("")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody E e) throws Exception {
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

package com.estilista.app.controller;

import java.io.Serializable;

import javax.validation.Valid;

import com.estilista.app.model.SuperClase;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IBaseController<E extends SuperClase, ID extends Serializable>
{
	public ResponseEntity<?> getAll() throws Exception;

	public ResponseEntity<?> getAllE() throws Exception;
	
	
	public ResponseEntity<?> getOne(@PathVariable ID id) throws Exception;
	public ResponseEntity<?> save(@Valid @RequestBody E e) throws Exception;

	public ResponseEntity<?> saveE(@Valid @RequestBody E e) throws Exception;
	
	public ResponseEntity<?> update(@PathVariable ID id,@RequestBody E e) throws Exception;
	public ResponseEntity<?> delete(@PathVariable ID id) throws Exception;
	

	public ResponseEntity<?> obtenerDatosId(@RequestBody E e) throws Exception;
}

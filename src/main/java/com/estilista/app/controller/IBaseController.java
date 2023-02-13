package com.estilista.app.controller;

import java.io.Serializable;

import javax.validation.Valid;

import com.estilista.app.model.SuperClase;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IBaseController<E extends SuperClase, ID extends Serializable>
{
	ResponseEntity<?> getAll() throws Exception;
	ResponseEntity<?> getAllE() throws Exception;
	ResponseEntity<?> getOne(@PathVariable ID id) throws Exception;
	ResponseEntity<?> save(@Valid @RequestBody E e) throws Exception;
	ResponseEntity<?> saveE(@Valid @RequestBody E e) throws Exception;
	ResponseEntity<?> update(@PathVariable ID id,@RequestBody E e) throws Exception;
	ResponseEntity<?> delete(@PathVariable ID id) throws Exception;
	
	ResponseEntity<?> obtenerDatosId(@RequestBody E e) throws Exception;
}

package com.estilista.app.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.estilista.app.dto.RespuestaDTO;
import com.estilista.app.model.SuperClase;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IBaseService <E extends SuperClase, ID extends Serializable>{
	
	public List<E> getAll() throws Exception;
	public Optional<E> getOne(ID id) throws Exception;
	public E update(ID id, E e) throws Exception;
	public E save(@RequestBody @Validated E e) throws Exception;
	public boolean delete(ID id) throws Exception;
	

	public RespuestaDTO<E> saveE(E e) throws Exception;
	public RespuestaDTO<List<E>> getAllE() throws Exception;
	public RespuestaDTO<Optional<E>> obtenerPost( @PathVariable ID id) throws Exception;
}

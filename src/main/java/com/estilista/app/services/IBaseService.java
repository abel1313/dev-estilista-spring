package com.estilista.app.services;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.estilista.app.dto.ImagenDto;
import com.estilista.app.dto.RespuestaDTO;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.SuperClase;

import org.hibernate.ResourceClosedException;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IBaseService <E extends SuperClase, ID extends Serializable>{
	
	public ResponseGeneric<Page<E>> getAll(@PathVariable final int page, @PathVariable final int size) throws Exception;
	public Optional<E> getOne(ID id) throws Exception;
	public ResponseGeneric<E> update(ID id, E e) throws Exception;
	public ResponseGeneric<E> save(@RequestBody @Validated E e) throws Exception;
	public boolean delete(ID id) throws Exception;
	

	public RespuestaDTO<E> saveE(E e) throws Exception;
	public RespuestaDTO<List<E>> getAllE() throws Exception;
	public RespuestaDTO<Optional<E>> obtenerPost( @PathVariable ID id) throws Exception;


	boolean createFile(final String nameDirectorio) throws ResourceClosedException;


}

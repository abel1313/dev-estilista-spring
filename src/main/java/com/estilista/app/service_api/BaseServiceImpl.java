package com.estilista.app.service_api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.estilista.app.dto.RespuestaDTO;
import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.SuperClase;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IBaseService;


public abstract class BaseServiceImpl<E extends SuperClase, ID extends Serializable> 
implements IBaseService<E, ID> {

	protected IBaseRepository<E, ID> iBaseRepository;
	
	public BaseServiceImpl( IBaseRepository<E, ID> iBaseRepository )
	{
			this.iBaseRepository = iBaseRepository;
	}

	@Override
	public ResponseGeneric<List<E>> getAll() throws Exception{
		final ResponseGeneric<List<E>> responseGeneric = new ResponseGeneric<>();
		try {
			final List<E> lista = this.iBaseRepository.findAll();
			if( lista.size() > 0 ) {
				responseGeneric.setCodeValue(200);
				responseGeneric.setDatos(lista);
			}
			
			return responseGeneric;
		}catch(Exception e)
		{
			 throw new ResourceNotFoundException(e.getMessage());
//			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ResponseGeneric<E> update(ID id, E e) throws Exception {
		try {
			ResponseGeneric<E> responseGeneric = new ResponseGeneric<>();
			
			Optional<E> entity = this.iBaseRepository.findById(id);
			if(entity.isPresent()) {
				E entityUpdate = entity.get();
				entityUpdate = this.iBaseRepository.save(entityUpdate);
				responseGeneric.setCodeValue(200);
				responseGeneric.setMensaje("Se actualizp correctamente");
			}else {
				responseGeneric.setMensaje("Ocurrio un error al actualizar");
			}
			
			return responseGeneric;
		}catch(Exception exception)
		{
			 throw new ResourceNotFoundException(exception.getMessage());
//			throw new Exception(exception.getMessage());
		}
	}
	@Override
	public ResponseGeneric<E> save(E e) throws Exception {
		ResponseGeneric<E> responseGeneric = new ResponseGeneric<>();
		
		try {
			final E guardar = this.iBaseRepository.save(e);
			if( guardar != null ) {
				responseGeneric.setCodeValue(200);
				responseGeneric.setMensaje("Se guardo correctamente");
			}else {

				responseGeneric.setMensaje("Ocurrio un error al guardar");
			}
			
			return responseGeneric;
		}catch(Exception exception)
		{

			 throw new ResourceNotFoundException(exception.getMessage());
//			throw new Exception(exception.getMessage());
		}
	}

	@Override
	public boolean delete(ID id) throws Exception {
		// TODO Auto-generated method stub
		try {
			if( this.iBaseRepository.existsById(id))
			{
				this.iBaseRepository.deleteById(id);
				return true;
			}else
			{
				return false;
			}
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<E> getOne(ID id) throws Exception {
		try {
			return this.iBaseRepository.existsById(id) ? this.iBaseRepository.findById(id) : Optional.empty();

		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public RespuestaDTO<E> saveE(E e) throws Exception {
		RespuestaDTO<E> respuesta = new RespuestaDTO<>();
		
		if( e != null )
		{
			try {
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Se creo correctamente");
				respuesta.setT(this.iBaseRepository.save(e));
				return respuesta;
			}catch(Exception exception)
			{
//				throw new Exception(e.getMessage());
				
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(500);
				respuesta.setMensaje("Ocurrio un error ");
				return respuesta;
				
			}
		}
		respuesta.setCode("200 OK");
		respuesta.setCodeValue(200);
		respuesta.setMensaje("Verificar la informaci??n");
		respuesta.setT(e);
		return respuesta;
	}

	@Override
	public RespuestaDTO<List<E>> getAllE() throws Exception {
		
		RespuestaDTO<List<E>> respuesta = new RespuestaDTO<>();
		
		try {
			List<E> lista =  this.iBaseRepository.findAll();
			if( !lista.isEmpty())
			{
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Se encontraron datos en la base de datos");
				respuesta.setT(this.iBaseRepository.findAll());
				return respuesta;
			}
			
		}catch(Exception exception)
		{
//			throw new Exception(e.getMessage());
			
			respuesta.setCode("200 OK");
			respuesta.setCodeValue(500);
			respuesta.setMensaje("Ocurrio un error ");
			return null;
			
		}
		respuesta.setCode("200 OK");
		respuesta.setCodeValue(200);
		respuesta.setMensaje("No se encontraron datos en la base de datos");
		respuesta.setT(new ArrayList<>());
		return respuesta;
	}

	@Override
	public RespuestaDTO<Optional<E>> obtenerPost(@PathVariable ID id) throws Exception {

			RespuestaDTO<Optional<E>> respuesta = new RespuestaDTO<>();
			
			if( id != null )
			{
				try {
					respuesta.setCode("200 OK");
					respuesta.setCodeValue(200);
					respuesta.setMensaje("Datos encontrados");
					respuesta.setT(this.iBaseRepository.findById(id));
					return respuesta;
				}catch(Exception exception)
				{
//					throw new Exception(e.getMessage());
					
					respuesta.setCode("200 OK");
					respuesta.setCodeValue(500);
					respuesta.setMensaje("Ocurrio un error ");
					respuesta.setT(Optional.empty());
					return respuesta;
					
				}
			}
			respuesta.setCode("200 OK");
			respuesta.setCodeValue(200);
			respuesta.setMensaje("Verificar la informaci??n");
			respuesta.setT(Optional.empty());
			return respuesta;
		}

	
}

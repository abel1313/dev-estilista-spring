package com.estilista.app.service_api;

import java.io.File;
import java.io.Serializable;
import java.util.*;

import org.hibernate.ResourceClosedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import com.estilista.app.dto.RespuestaDTO;
import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.SuperClase;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IBaseService;


public abstract class BaseServiceImpl<E extends SuperClase, ID extends Serializable> 
implements IBaseService<E, ID> {

	protected final String urlDirectory = ".//src//main//resources//imagenes//";
	protected final String PATH = "src//main//resources//imagenes//";
	protected Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	protected IBaseRepository<E, ID> iBaseRepository;
	
	public BaseServiceImpl( final IBaseRepository<E, ID> iBaseRepository )
	{
			this.iBaseRepository = iBaseRepository;
	}

	@Override
	public ResponseGeneric<Page<E>> getAll(@PathVariable final int page,@PathVariable final int size) throws Exception{
		final ResponseGeneric<Page<E>> responseGeneric = new ResponseGeneric<>();
		try {
			final Pageable pageable = PageRequest.of(page,size);
			final Page<E> lista = this.iBaseRepository.findAll(pageable);
			if(Objects.nonNull(lista) ) {
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
		
		System.err.println("si llefo");
		ResponseGeneric<E> responseGeneric = new ResponseGeneric<>();

		try {

			final E guardar = this.iBaseRepository.save(e);
			if( guardar != null ) {
				responseGeneric.setCodeValue(200);
				responseGeneric.setDatos(guardar);
				responseGeneric.setMensaje("Se guardo correctamente");
			}else {

				responseGeneric.setMensaje("Ocurrio un error al guardar");
			}
			
			return responseGeneric;
		}catch(Exception exception)
		{
			System.err.println("si llefo cpontroler service");
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
		respuesta.setMensaje("Verificar la información");
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
			respuesta.setMensaje("Verificar la información");
			respuesta.setT(Optional.empty());
			return respuesta;
		}

		@Override
		public boolean createFile(final String nameDirectorio) throws ResourceClosedException {
		boolean fileCrete = false;
			final File directorio = new File(urlDirectory.concat("//").concat(nameDirectorio)).getAbsoluteFile();
			if (!directorio.exists()) {
				if (directorio.mkdirs()) {
					logger.info("Directorio creado");
					fileCrete = true;
				} else {
					throw new ResourceClosedException("Ocurrio un error al generar el directorio");
				}
			}else{
				fileCrete = true;
			}

			return fileCrete;
		}



}

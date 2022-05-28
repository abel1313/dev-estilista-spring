package com.estilista.app.services;

import java.util.stream.Stream;

import com.estilista.app.dto.MostrarClienteDTO;
import com.estilista.app.dto.RespuestaDTO;
import com.estilista.app.model.Cliente;


public interface IClienteService extends IBaseService<Cliente, Integer> {
	
	
	public RespuestaDTO<Stream<MostrarClienteDTO>> obtenerClientes() throws Exception;

}

package com.estilista.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.estilista.app.model.Direccion;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.services.IDireccioneService;

class DireccionControllerTest {

	@Mock
	private IDireccioneService iDireccioneService;
	
	@InjectMocks
	private DireccionController direccionController;
	
	private List<Direccion> LISTA_DIRECCIONES = new ArrayList<Direccion>();
	
	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
		LISTA_DIRECCIONES.add(new Direccion());
	}

	@Test
	void testGetAll() throws Exception {
		ResponseGeneric<List<Direccion>> response = new ResponseGeneric<List<Direccion>>();
		when(iDireccioneService.getAll())
		.thenReturn(response);
		assertNotNull(direccionController.getAll());
	}

}

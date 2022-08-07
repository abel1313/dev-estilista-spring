package com.estilista.app.service_api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.estilista.app.model.Direccion;
import com.estilista.app.repositories.IDireccionReporitory;

class DireccionServiceImplTest2 {

	@Mock
	private IDireccionReporitory iDireccionReporitory;
	
	@InjectMocks
	private DireccionServiceImpl isDireccioneService;
	
	private List<Direccion> lista = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		lista.add(new Direccion("","","",""));
		
		when(iDireccionReporitory.findAll()).thenReturn(lista);
	}

	@Test
	void test() {
		assertNotNull(isDireccioneService.obtenerTodos());
	}

}

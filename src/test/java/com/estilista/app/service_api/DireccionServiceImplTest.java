package com.estilista.app.service_api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.estilista.app.repositories.IDireccionReporitory;


class DireccionServiceImplTest {

	@Mock
	private IDireccionReporitory iDireccionReporitory;
	
	@InjectMocks
	private DireccionServiceImpl direccionServiceImpl;
	
	@Mock
	 List<String> mockList;
	 
	@BeforeEach
	void setUp() throws Exception {
		
	    
	    mockList.add("one");
	    
		 Mockito.when(mockList.size()).thenReturn(100);
	}

	@Test
	void test() {


	   
	    assertEquals(100, mockList.size());
	}

}

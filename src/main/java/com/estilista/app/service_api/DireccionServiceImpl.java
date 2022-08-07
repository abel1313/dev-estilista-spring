package com.estilista.app.service_api;

import com.estilista.app.model.Direccion;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.IDireccionReporitory;
import com.estilista.app.services.IDireccioneService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DireccionServiceImpl extends BaseServiceImpl<Direccion, Integer>implements IDireccioneService
{
	@Autowired
	private IDireccionReporitory iDireccionReporitory;
	public DireccionServiceImpl(IBaseRepository<Direccion, Integer> iBaseRepository) {
		super(iBaseRepository);
		
	}
	@Override
	public List<Direccion> obtenerTodos() {
		return iDireccionReporitory.findAll();
	}
	
	
	


}

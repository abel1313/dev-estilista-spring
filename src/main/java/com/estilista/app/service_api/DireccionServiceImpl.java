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

	private IDireccionReporitory iDireccionReporitory;
	public DireccionServiceImpl(final IBaseRepository<Direccion, Integer> iBaseRepository) {
		super(iBaseRepository);
	}
	@Autowired
	public void setiDireccionReporitory(final IDireccionReporitory iDireccionReporitory) {
		this.iDireccionReporitory = iDireccionReporitory;
	}

	@Override
	public List<Direccion> obtenerTodos() {
		return iDireccionReporitory.findAll();
	}
	
	
	


}

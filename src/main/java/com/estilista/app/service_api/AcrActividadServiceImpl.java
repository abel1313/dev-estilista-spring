package com.estilista.app.service_api;

import org.springframework.stereotype.Service;

import com.estilista.app.model.ACrActividad;
import com.estilista.app.model.Direccion;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IAcActividadService;
import com.estilista.app.services.IDireccioneService;

@Service
public class AcrActividadServiceImpl extends BaseServiceImpl<ACrActividad, Integer>implements IAcActividadService
{

	public AcrActividadServiceImpl(IBaseRepository<ACrActividad, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}

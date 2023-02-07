package com.estilista.app.service_api;

import org.springframework.stereotype.Service;

import com.estilista.app.model.ACr;
import com.estilista.app.model.ACrActividad;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IAcActividadService;
import com.estilista.app.services.IAcService;

@Service
public class AcrServiceImpl extends BaseServiceImpl<ACr, Integer>implements IAcService
{

	public AcrServiceImpl(IBaseRepository<ACr, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}

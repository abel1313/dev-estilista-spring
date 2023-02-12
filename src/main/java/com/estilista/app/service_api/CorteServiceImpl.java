package com.estilista.app.service_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estilista.app.model.Corte;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.ICorteRepository;
import com.estilista.app.services.ICorteService;

@Service
public class CorteServiceImpl extends BaseServiceImpl<Corte, Integer>implements ICorteService{


	public CorteServiceImpl(IBaseRepository<Corte, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}

package com.estilista.app.service_api;

import com.estilista.app.model.Ruta;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IRutaService;
import org.springframework.stereotype.Service;

@Service
public class RutaServiceImpl extends BaseServiceImpl<Ruta, Integer>implements IRutaService {
    public RutaServiceImpl(IBaseRepository<Ruta, Integer> iBaseRepository) {
        super(iBaseRepository);
    }
}

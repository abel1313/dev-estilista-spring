package com.estilista.app.service_api;

import com.estilista.app.model.RutaHeader;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IRutaHeaderService;
import org.springframework.stereotype.Service;

@Service
public class RutaHeaderServiceImpl  extends BaseServiceImpl<RutaHeader, Integer>implements IRutaHeaderService {
    public RutaHeaderServiceImpl(IBaseRepository<RutaHeader, Integer> iBaseRepository) {
        super(iBaseRepository);
    }
}

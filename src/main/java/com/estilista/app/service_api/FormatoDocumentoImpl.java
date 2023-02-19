package com.estilista.app.service_api;

import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.FormatoDocumento;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.IFormatoDocumentoRepository;
import com.estilista.app.services.IFormatoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class FormatoDocumentoImpl extends BaseServiceImpl<FormatoDocumento, Integer>implements IFormatoDocumentoService {

    @Autowired
    private IFormatoDocumentoRepository iFormatoDocumentoRepository;

    public FormatoDocumentoImpl(IBaseRepository<FormatoDocumento, Integer> iBaseRepository) {
        super(iBaseRepository);
    }


    public Optional<FormatoDocumento> findByExtencionOptional(@PathVariable final String extencion) throws ResourceNotFoundException{
        return this.iFormatoDocumentoRepository.findByExtencion(extencion);
    }
}

package com.estilista.app.services;

import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.FormatoDocumento;
import com.estilista.app.model.Producto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface IFormatoDocumentoService extends IBaseService<FormatoDocumento, Integer>{

    Optional<FormatoDocumento> findByExtencionOptional(@PathVariable final String extencion) throws ResourceNotFoundException;
}

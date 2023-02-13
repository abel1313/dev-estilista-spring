package com.estilista.app.services;

import com.estilista.app.dto.CorteDto;
import com.estilista.app.dto.UploadDocumentoDto;
import com.estilista.app.model.Cliente;
import com.estilista.app.model.Corte;
import com.estilista.app.model.ResponseGeneric;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;

public interface ICorteService extends IBaseService<Corte, Integer> {


    ResponseGeneric<Page<CorteDto>> getAllCortePageService(@PathVariable final int page, @PathVariable final int size) throws Exception;

}

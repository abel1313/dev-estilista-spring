package com.estilista.app.services;

import com.estilista.app.dto.CorteDto;
import com.estilista.app.dto.UploadDocumentoDto;
import com.estilista.app.model.Corte;
import com.estilista.app.model.ResponseGeneric;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICorteService extends IBaseService<Corte, Integer> {


    ResponseGeneric<List<CorteDto>> getAllCortePageService(@PathVariable final int page, @PathVariable final int size) throws Exception;

    ResponseGeneric<Boolean> saveCorte(@RequestBody final UploadDocumentoDto uploadDocumentoDto) throws Exception;

}

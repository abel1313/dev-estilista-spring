package com.estilista.app.services;

import com.estilista.app.dto.CorteDto;
import com.estilista.app.model.Corte;
import com.estilista.app.model.ResponseGeneric;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICorteService extends IBaseService<Corte, Integer> {


    ResponseGeneric<List<CorteDto>> getAllCortePageService(@PathVariable final int page, @PathVariable final int size) throws Exception;

}

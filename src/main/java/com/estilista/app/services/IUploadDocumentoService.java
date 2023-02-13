package com.estilista.app.services;

import com.estilista.app.dto.UploadDocumentoDto;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.UploadDocumento;
import com.estilista.app.model.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUploadDocumentoService extends IBaseService<UploadDocumento, Integer>{

     ResponseGeneric<Boolean> upload(@RequestBody final UploadDocumentoDto uploadDocumentoDto) throws Exception;

     ResponseGeneric<UploadDocumentoDto> getImages(@PathVariable final int id) throws Exception;

}

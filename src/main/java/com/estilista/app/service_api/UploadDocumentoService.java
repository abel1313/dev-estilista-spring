package com.estilista.app.service_api;

import com.estilista.app.model.UploadDocumento;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IUploadDocumentoService;
import org.springframework.stereotype.Service;

@Service
public class UploadDocumentoService extends BaseServiceImpl<UploadDocumento, Integer>implements IUploadDocumentoService {
    public UploadDocumentoService(IBaseRepository<UploadDocumento, Integer> iBaseRepository) {
        super(iBaseRepository);
    }
}

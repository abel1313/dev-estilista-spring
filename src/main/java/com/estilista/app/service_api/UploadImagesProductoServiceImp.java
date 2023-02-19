package com.estilista.app.service_api;

import com.estilista.app.model.UploadImagesProducto;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IUploadImagesPrductoService;
import org.springframework.stereotype.Service;

@Service
public class UploadImagesProductoServiceImp extends BaseServiceImpl<UploadImagesProducto, Integer>implements IUploadImagesPrductoService {
    public UploadImagesProductoServiceImp(IBaseRepository<UploadImagesProducto, Integer> iBaseRepository) {
        super(iBaseRepository);
    }
}

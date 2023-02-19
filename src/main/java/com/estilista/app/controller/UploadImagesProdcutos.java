package com.estilista.app.controller;

import com.estilista.app.model.RutaHeader;
import com.estilista.app.model.UploadImagesProducto;
import com.estilista.app.service_api.RutaHeaderServiceImpl;
import com.estilista.app.service_api.UploadImagesProductoServiceImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyecto/productosImagenes")
public class UploadImagesProdcutos  extends BaseControllerImpl<UploadImagesProducto, UploadImagesProductoServiceImp>{
}

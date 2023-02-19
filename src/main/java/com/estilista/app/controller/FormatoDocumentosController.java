package com.estilista.app.controller;

import com.estilista.app.model.Direccion;
import com.estilista.app.model.FormatoDocumento;
import com.estilista.app.service_api.DireccionServiceImpl;
import com.estilista.app.service_api.FormatoDocumentoImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("proyecto/formato")
public class FormatoDocumentosController  extends BaseControllerImpl<FormatoDocumento, FormatoDocumentoImpl>{
}

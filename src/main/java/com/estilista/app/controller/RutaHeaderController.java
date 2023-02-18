package com.estilista.app.controller;

import com.estilista.app.model.RutaHeader;
import com.estilista.app.service_api.RutaHeaderServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyecto/rutas-header")
public class RutaHeaderController extends BaseControllerImpl<RutaHeader, RutaHeaderServiceImpl> {
}

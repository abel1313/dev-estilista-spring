package com.estilista.app.controller;

import com.estilista.app.model.Ruta;
import com.estilista.app.service_api.RutaServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyecto/rutas")
public class RutaController extends BaseControllerImpl<Ruta, RutaServiceImpl>{
}

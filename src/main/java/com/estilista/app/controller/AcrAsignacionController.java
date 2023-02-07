package com.estilista.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilista.app.model.ACr;
import com.estilista.app.model.ACrActividad;
import com.estilista.app.service_api.AcrActividadServiceImpl;
import com.estilista.app.service_api.AcrServiceImpl;

@RestController
@RequestMapping("proyecto/asig")
public class AcrAsignacionController extends BaseControllerImpl<ACrActividad, AcrActividadServiceImpl>{

}

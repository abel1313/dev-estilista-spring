package com.estilista.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilista.app.model.ACr;
import com.estilista.app.model.Direccion;
import com.estilista.app.service_api.AcrServiceImpl;
import com.estilista.app.service_api.DireccionServiceImpl;

@RestController
@RequestMapping("proyecto/acr")
public class AcrController extends BaseControllerImpl<ACr, AcrServiceImpl>{

}

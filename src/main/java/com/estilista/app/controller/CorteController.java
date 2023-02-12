package com.estilista.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilista.app.model.Corte;
import com.estilista.app.service_api.CorteServiceImpl;
import com.estilista.app.services.ICorteService;

@RestController
@RequestMapping("proyecto/cortes")
public class CorteController extends BaseControllerImpl<Corte, CorteServiceImpl>{

}

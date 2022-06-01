package com.estilista.app.controller;

import com.estilista.app.model.Direccion;
import com.estilista.app.service_api.DireccionServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("proyecto/direccion")
public class DireccionController extends BaseControllerImpl<Direccion, DireccionServiceImpl>{
    
}

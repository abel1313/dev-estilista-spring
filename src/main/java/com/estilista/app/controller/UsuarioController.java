package com.estilista.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilista.app.model.Producto;
import com.estilista.app.model.Usuario;
import com.estilista.app.service_api.ProductoServiceImp;
import com.estilista.app.service_api.UsuarioServiceImpl;

@RestController
@RequestMapping("proyecto/usuarios")
public class UsuarioController  extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

}

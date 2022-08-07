package com.estilista.app.controller;

import com.estilista.app.dto.ValidarDireccion;
import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.Direccion;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.service_api.DireccionServiceImpl;
import com.estilista.app.services.IDireccioneService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("proyecto/direccion")
public class DireccionController extends BaseControllerImpl<Direccion, DireccionServiceImpl>{
    
	@Autowired
	private IDireccioneService iDireccioneService;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ValidarDireccion()); // registramos el validador
    }
	
	@GetMapping("solo")
	public ResponseEntity<?> dale() throws Exception {
		try {
			Direccion d = new Direccion();
			d.setEstadoDireccion(null);
			d.setColoniaDireccion("a");
			d.setCalleDireccion("ahi");
			d.setMunicipioDireccion("m");
			DataBinder b = new DataBinder(d);
			if(b.getBindingResult().hasErrors()) {
				System.err.println("Guardando ");
				b.getBindingResult().getAllErrors().forEach(System.out::println);
			}
		
		
			return ResponseEntity.status(HttpStatus.OK).body(this.iDireccioneService.getAll() );
		} catch (Exception ee) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
		}
	}
	
}

package com.estilista.app.controller;

import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.Ruta;
import com.estilista.app.service_api.RutaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyecto/rutas")
public class RutaController extends BaseControllerImpl<Ruta, RutaServiceImpl>{


    @GetMapping("/getData")
    public ResponseEntity<?> getAllData() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.service.getAllE() );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResourceNotFoundException(e.getMessage()));
        }

    }
}

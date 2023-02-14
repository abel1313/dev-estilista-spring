package com.estilista.app.controller;

import com.estilista.app.dto.CorteDto;
import com.estilista.app.model.Corte;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.service_api.CorteServiceImpl;
import com.estilista.app.services.ICorteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("proyecto/cortes")
public class CorteController extends BaseControllerImpl<Corte, CorteServiceImpl>{


    private ICorteService iCorteService;
    @Autowired
    public void setiCorteService(final ICorteService iCorteService) {
        this.iCorteService = iCorteService;
    }

    @GetMapping(value = "/getAllPage/{page}/{size}")
    public ResponseEntity<ResponseGeneric<List<CorteDto>>> getAllCortePage(@PathVariable final int page, @PathVariable final int size) {
        ResponseGeneric<List<CorteDto>> responseGeneric = new ResponseGeneric<>();
        try{
            responseGeneric = this.iCorteService.getAllCortePageService(page,size);
            return ResponseEntity.status(HttpStatus.OK).body(responseGeneric);
        }catch (Exception e){
            logger.error(" {} ",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneric);
        }
    }

}

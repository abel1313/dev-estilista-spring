package com.estilista.app.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

@Data
public class UploadDocumentoDto {

    private int id;
    private String base64;
    private String nombreImagen;
    private String extencion;

}

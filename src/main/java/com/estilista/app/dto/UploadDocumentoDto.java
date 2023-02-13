package com.estilista.app.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UploadDocumentoDto extends SuperDto {

    TipoCorteDto tipoCorte;
    List<ImagenDto> imagenes;

}

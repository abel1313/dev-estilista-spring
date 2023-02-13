package com.estilista.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UploadDto extends  SuperDto {
    private String nombreCorte;
    double precioTipoCorte;
    private String base64Image;
}

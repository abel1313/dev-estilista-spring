package com.estilista.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImagenDto extends  SuperDto {
    private String nombreImagen;
    private String extencionImagen;
    private String base64Imagen;
}

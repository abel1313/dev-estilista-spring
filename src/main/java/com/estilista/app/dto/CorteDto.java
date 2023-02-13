package com.estilista.app.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CorteDto extends SuperDto{
    TipoCorteDto tipoCorte;
    List<ImagenDto> imagenes;
}

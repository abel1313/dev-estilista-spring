package com.estilista.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipoCorteDto extends SuperDto {

    private String nombreCorte;
    private double precioTipoCorte;
}

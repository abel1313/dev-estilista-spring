package com.estilista.app.dto;

import com.estilista.app.model.Producto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UploadImagesProductoDto {


    private Producto producto;
    private List<ImagenDto> list;
}

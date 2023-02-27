package com.estilista.app.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Abel Tiburcio
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "IMAGENES_TEMP")
public class ImagenTemporal extends SuperClase{

    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;


    @Column(name = "ID_IMAGEN")
    private int idImagen;
}

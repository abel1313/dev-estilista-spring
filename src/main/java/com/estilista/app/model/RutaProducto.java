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
//@Entity
//@Table(name = "RUTAS_PRODUCTOS")
public class RutaProducto extends SuperClase{

    @Column( name = "NOMBRE_PRUDCTO")
    private String nombreProducto;
}

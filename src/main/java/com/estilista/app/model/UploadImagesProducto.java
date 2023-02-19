package com.estilista.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "UPLOAD_IMAGES_PRODUCTOS")
public class UploadImagesProducto extends SuperClase{

    @Column( name = "NOMBRE_IMAGEN")
    private String nombreImagen;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FORMATO_ID")
    private FormatoDocumento formatoDocumento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCTO_ID")
    private Producto producto;

    public UploadImagesProducto(final String nombreImagen, final FormatoDocumento formatoDocumento, final Producto producto){
        this.nombreImagen = nombreImagen;
        this.formatoDocumento = formatoDocumento;
        this.producto = producto;
    }

}

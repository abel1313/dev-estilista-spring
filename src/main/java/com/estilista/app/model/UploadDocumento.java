package com.estilista.app.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "UPLOAD_DOCUMENTS")
public class UploadDocumento extends SuperClase{

    @Column( name = "NOMBRE_IMAGEN")
    private String nombreImagen;
    @Column( name = "EXTENCION")
    private String extencion;

    public UploadDocumento(final String nombreDocumento, final String extencion){
        this.nombreImagen = nombreDocumento;
        this.extencion = extencion;
    }
}

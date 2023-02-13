package com.estilista.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "UPLOAD_DOCUMENTS")
public class UploadDocumento extends SuperClase{

    @Column( name = "NOMBRE_IMAGEN")
    private String nombreImagen;
    @Column( name = "EXTENCION")
    private String extencion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CORTE_ID")
    @JsonBackReference
    private Corte corteTipo;

    public UploadDocumento(final String nombreDocumento, final String extencion){
        this.nombreImagen = nombreDocumento;
        this.extencion = extencion;
    }

    public UploadDocumento(final String nombreDocumento, final String extencion, final Corte corteTipo){
        this.nombreImagen = nombreDocumento;
        this.extencion = extencion;
        this.corteTipo = corteTipo;
    }


    @Override
    public String toString() {
        return "UploadDocumento{" +
                "nombreImagen='" + nombreImagen + '\'' +
                ", extencion='" + extencion + '\'' +
                ", corteTipo=" + corteTipo +
                '}';
    }
}

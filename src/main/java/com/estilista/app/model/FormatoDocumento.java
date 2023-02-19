package com.estilista.app.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Abel Tiburcio
 * @param activo
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "FORMATOS_DOCUMENTOS")
public class FormatoDocumento extends SuperClase{

    @Column( name = "EXTENCION")
    private String extencion;

    public FormatoDocumento(final int id, final String extencion){
        super(id);
        this.extencion =extencion;
    }
}

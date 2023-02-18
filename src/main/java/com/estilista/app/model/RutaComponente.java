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
@Table(name = "RUTAS_COMPONENTES")
public class RutaComponente extends SuperClase{

    @Column( name = "NOMBRE_COMPONENTE")
    private String nombreComponente;
}

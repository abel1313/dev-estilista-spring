package com.estilista.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Abel Tiburcio
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "RUTAS_HEADER")
public class RutaHeader extends SuperClase{
    @ManyToOne
    @JoinColumn(name="RUTA_ID", nullable=false)
    @JsonBackReference
    private Ruta ruta;

    @OneToOne
    @JoinColumn(name="COMPONENTE_ID", nullable=false)
    private RutaComponente rutaComponente;


    @OneToOne
    @JoinColumn(name="ACCIONES_RUTA_ID", nullable=false)
    private RutaAccion rutaAccion;


}

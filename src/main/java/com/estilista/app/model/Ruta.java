package com.estilista.app.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@Table(name = "RUTAS")
public class Ruta extends SuperClase{


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta")
    private List<RutaHeader> lista;


    private String nombre;




	 
}

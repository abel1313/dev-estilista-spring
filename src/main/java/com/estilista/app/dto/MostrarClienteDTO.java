package com.estilista.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MostrarClienteDTO 
{
	
    private Integer id;
    private String nombre;
    private String apeidos;
    private String estado;

}

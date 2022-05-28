package com.estilista.app.model;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param clienteCita
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Cliente extends SuperClase{
	
	  @Column( name = "PERSONA_ID")
	  private Persona personaCliente;
	
	
}

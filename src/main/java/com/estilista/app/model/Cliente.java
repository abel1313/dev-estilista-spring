package com.estilista.app.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
@ToString
@Entity
@Table(name = "CLIENTES")
public class Cliente extends SuperClase{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -4687714862919741080L;
	
	@OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn( name = "PERSONA_ID")
	  private Persona personaCliente;
	
	
}

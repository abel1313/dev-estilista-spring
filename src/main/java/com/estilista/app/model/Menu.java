package com.estilista.app.model;



import javax.persistence.Column;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param nombreMenu
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Menu extends SuperClase{

	  @Column( name = "NOMBRE_MENU")
	  private String nombreMenu;
	
	
}

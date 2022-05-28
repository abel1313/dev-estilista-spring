package com.estilista.app.model;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Abel Tiburcio
 * @param ruta
 * @param menuPermiso
 * @param rol
 * */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permiso {
	  
	  @Column( name = "RUTA_ID")
	  private Ruta ruta;
	  
	  @Column( name = "MENUS_ID")
	  private Menu menuPermiso;
	  
	  @Column( name = "ROLES_ID")
	  private Rol rol;

}

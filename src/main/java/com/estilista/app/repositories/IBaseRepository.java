package com.estilista.app.repositories;

import java.io.Serializable;

import com.estilista.app.model.SuperClase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;



@NoRepositoryBean
public interface IBaseRepository<E extends SuperClase, ID extends Serializable> extends JpaRepository<E, ID>{

}

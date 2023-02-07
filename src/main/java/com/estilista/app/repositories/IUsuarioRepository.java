package com.estilista.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estilista.app.model.Producto;
import com.estilista.app.model.Usuario;

@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario, Integer>{

}

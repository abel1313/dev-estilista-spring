package com.estilista.app.repositories;

import org.springframework.stereotype.Repository;

import com.estilista.app.model.Cliente;


@Repository
public interface IClienteRepository extends IBaseRepository<Cliente, Integer> {

}

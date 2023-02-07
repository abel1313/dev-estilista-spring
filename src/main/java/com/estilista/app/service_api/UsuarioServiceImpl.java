package com.estilista.app.service_api;

import org.springframework.stereotype.Service;

import com.estilista.app.model.Producto;
import com.estilista.app.model.Usuario;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.IProductoService;
import com.estilista.app.services.IUsuarioServide;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer>implements IUsuarioServide{

	public UsuarioServiceImpl(IBaseRepository<Usuario, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}

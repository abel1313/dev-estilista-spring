package com.estilista.app.service_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.estilista.app.model.Producto;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.IProductoRepository;
import com.estilista.app.services.IProductoService;

@Service
public class ProductoServiceImp extends BaseServiceImpl<Producto, Integer>implements IProductoService{


	private IProductoRepository iProductoRepository;
	
	public ProductoServiceImp(final IBaseRepository<Producto, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public void setiProductoRepository(final IProductoRepository iProductoRepository) {
		this.iProductoRepository = iProductoRepository;
	}

	@Override
	public List<Producto> findByNombreProductoContaining(@Param("nombre") String nombre ){
		return this.iProductoRepository.findByNombreProductoContaining(nombre);
	}

}

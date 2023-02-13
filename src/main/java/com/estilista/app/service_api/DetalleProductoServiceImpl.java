package com.estilista.app.service_api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estilista.app.dto.DetalleProductoDto;
import com.estilista.app.model.DetalleProducto;
import com.estilista.app.model.Direccion;
import com.estilista.app.model.Producto;
import com.estilista.app.model.Venta;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.IDetalleProductoRepository;
import com.estilista.app.repositories.IDireccionReporitory;
import com.estilista.app.services.IDetalleProductoService;
import com.estilista.app.services.IDireccioneService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class DetalleProductoServiceImpl extends BaseServiceImpl<DetalleProducto, Integer>implements IDetalleProductoService
{
	private IDetalleProductoRepository iDetalleProductoRepository;
	public DetalleProductoServiceImpl(IBaseRepository<DetalleProducto, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public void setiDetalleProductoRepository(final IDetalleProductoRepository iDetalleProductoRepository) {
		this.iDetalleProductoRepository = iDetalleProductoRepository;
	}

	@Override
	public List<DetalleProducto> saveDetalle(@RequestBody final List<DetalleProductoDto> detalleProductoDto) throws Exception {
		try {
			final Venta venta = new Venta();
			final List<DetalleProducto> list =detalleProductoDto.stream().map(m->{
				final DetalleProducto detalleProducto = new DetalleProducto();
				final Producto producto = new Producto();
				producto.setId(m.getId());
				detalleProducto.setSubTotal(m.getPrecio());
				
				
				return detalleProducto;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}

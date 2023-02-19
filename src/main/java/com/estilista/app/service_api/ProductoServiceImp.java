package com.estilista.app.service_api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.estilista.app.dto.ImagenDto;
import com.estilista.app.dto.UploadImagesProductoDto;
import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.*;
import com.estilista.app.repositories.IUploadImagesProductoRepository;
import com.estilista.app.services.IFormatoDocumentoService;
import com.estilista.app.services.IUploadImagesPrductoService;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.IProductoRepository;
import com.estilista.app.services.IProductoService;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductoServiceImp extends BaseServiceImpl<Producto, Integer>implements IProductoService{


	private IProductoRepository iProductoRepository;
	private IFormatoDocumentoService iFormatoDocumentoService;
	private IUploadImagesPrductoService iUploadImagesPrductoService;


	@Autowired
	private IUploadImagesProductoRepository iUploadImagesProductoRepository;
	
	public ProductoServiceImp(final IBaseRepository<Producto, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public void setiProductoRepository(final IProductoRepository iProductoRepository) {
		this.iProductoRepository = iProductoRepository;
	}

	@Autowired
	public void setiFormatoDoucmento(final IFormatoDocumentoService iFormatoDocumentoService) {
		this.iFormatoDocumentoService = iFormatoDocumentoService;
	}

	@Autowired
	public void setiUploadImagesPrductoService(IUploadImagesPrductoService iUploadImagesPrductoService) {
		this.iUploadImagesPrductoService = iUploadImagesPrductoService;
	}

	@Override
	public List<Producto> findByNombreProductoContaining(@Param("nombre") String nombre ){
		return this.iProductoRepository.findByNombreProductoContaining(nombre);
	}

	@Override
	public ResponseGeneric<Boolean> saveProductoImage(Producto producto) throws ResourceClosedException, Exception {
		return null;
	}

	public ResponseGeneric<Boolean> saveProductoImage(@RequestBody final UploadImagesProductoDto producto) throws Exception {

		iUploadImagesProductoRepository.save(new UploadImagesProducto("name 1", new FormatoDocumento(1,""),new Producto("prod",new TamanioProducto("pe",2.0),new Estatus('1'))));
		final ResponseGeneric<Boolean> responseGeneric = new ResponseGeneric<>();
		responseGeneric.setDatos(false);
		final String NAME_PRODUCTO = "productos";
		if( createFile(NAME_PRODUCTO) ){

				try {
					final List<ImagenDto> listImg = producto.getList().stream().map(m->{
						final ImagenDto uploadImagesProducto = new ImagenDto();
						final Optional<FormatoDocumento> formatoDocumento = this.iFormatoDocumentoService.findByExtencionOptional(m.getExtencionImagen());
						if( !formatoDocumento.isPresent()){
							throw new ResourceNotFoundException("El formato es uncorrecto");
						}
						uploadImagesProducto.setNombreImagen(m.getNombreImagen());
						uploadImagesProducto.setBase64Imagen(m.getBase64Imagen());
						uploadImagesProducto.setExtencionImagen(String.valueOf(formatoDocumento.get().getId()));
						return  uploadImagesProducto;
					}).collect(Collectors.toList());
					if( !listImg.isEmpty()){
						logger.debug(" seb {} ",listImg);
						listImg.forEach(sa->{
							try {
								final ResponseGeneric<Producto> p = save(producto.getProducto());
								final FormatoDocumento f = new FormatoDocumento();
								f.setId(Integer.parseInt(sa.getExtencionImagen()));
								final ResponseGeneric<UploadImagesProducto> saveImg = iUploadImagesPrductoService
										.save(new UploadImagesProducto(sa.getNombreImagen(),
												f,p.getDatos()));
								FileWriter fw = new FileWriter(urlDirectory.concat("//productos//")
										.concat(String.valueOf(new Date().getTime()))
										.concat("-")
										.concat(String.valueOf(saveImg.getDatos().getId()))
										.concat(".txt"));
								BufferedWriter bw = new BufferedWriter(fw);
								bw.write(sa.getBase64Imagen());
								bw.close();
							} catch (Exception e) {
								throw new ResourceNotFoundException(e.getMessage());
							}
						});
					}

				} catch (Exception e) {
					logger.error(" Ocurrio un error al escribir el documento UploadDocumentoService, upload {} ",e.getMessage());
					throw new RuntimeException(e);
				}
			responseGeneric.setMensaje("Se guardo el producto");
			responseGeneric.setCodeValue(200);
			responseGeneric.setDatos(true);
		}else{
			responseGeneric.setMensaje("La carpeta no se creo");
		}

		return responseGeneric;
	}



}

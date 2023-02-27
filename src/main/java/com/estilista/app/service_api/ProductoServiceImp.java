package com.estilista.app.service_api;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import com.estilista.app.dto.*;
import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.*;
import com.estilista.app.repositories.IImagenRepository;
import com.estilista.app.repositories.IUploadImagesProductoRepository;
import com.estilista.app.services.IFormatoDocumentoService;
import com.estilista.app.services.IIMagenTemporalService;
import com.estilista.app.services.IUploadImagesPrductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.IProductoRepository;
import com.estilista.app.services.IProductoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductoServiceImp extends BaseImagenesAbstract{


	public ProductoServiceImp(IBaseRepository<Producto, Integer> iBaseRepository) {
		super(iBaseRepository);
	}

	@Override
	public List<Producto> findByNombreProductoContaining(@Param("nombre") String nombre ){
		return this.iProductoRepository.findByNombreProductoContaining(nombre);
	}

	@Override
	public ResponseGeneric<Boolean> saveProductoImage(@RequestBody final UploadImagesProductoDto producto) throws ResourceNotFoundException {
		final ResponseGeneric<Boolean> responseGeneric = new ResponseGeneric<>();
		responseGeneric.setDatos(false);
		final Producto per =iProductoRepository.save( producto.getProducto());
		if( Objects.nonNull(per)){
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

								final FormatoDocumento f = new FormatoDocumento();
								f.setId(Integer.parseInt(sa.getExtencionImagen()));
								final ResponseGeneric<UploadImagesProducto> saveImg = iUploadImagesPrductoService
										.save(new UploadImagesProducto(sa.getNombreImagen(),
												f,per));
								FileWriter fw = new FileWriter(urlDirectory.concat(NAME_FOLDER_PRODUCTOS)
										.concat(NAME_BARRA)
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
		}
		return responseGeneric;
	}



	private void deletePath(final Producto prod1){
		List<Integer> listaIds = prod1.getListaImagenes().stream().map(mappId->mappId.getId()).collect(Collectors.toList());
		final File files = new File(PATH_PRODUCTOS).getAbsoluteFile();

		listaIds.forEach(fo->{
			final Optional<File> exist = Arrays.stream(files.listFiles()).filter(f -> {
				final String divideCadena[] = f.getName().split("-");
				final String cadenaEncontrada = divideCadena[1].replace(".txt", "");
				return cadenaEncontrada.equals(String.valueOf(fo));
			}).findFirst();
			if( exist.isPresent()){
				final File fil = exist.get();
				final String name = fil.getAbsolutePath();

				try {
					Files.delete(fil.toPath());
					logger.error("%s not empty%n", name);
				} catch (IOException x) {
					logger.error("%s not empty%n", x.getMessage());
				}

			}
		});
	}
	@Override
	public ResponseGeneric<Boolean>  updateProductoImage(@RequestBody final UploadImagesProductoDto producto) throws ResourceNotFoundException {
		final ResponseGeneric<Boolean> responseGeneric = new ResponseGeneric<>();
		responseGeneric.setDatos(false);


		final Optional<Producto> per2 =iProductoRepository.findById( producto.getProducto().getId() );

		Producto productoUpdate = per2.get();

		final List<ImagenTemporal> imagenTemporals = productoUpdate.getListaImagenes().stream().map(m->{
			ImagenTemporal imgTemp = new ImagenTemporal();
			imgTemp.setNombreProducto("producto");
			imgTemp.setIdImagen(m.getId());
			return imgTemp;
		}).collect(Collectors.toList());


		final List<ImagenTemporal> saveIma = this.iImagenRepository.saveAll(imagenTemporals);
		iUploadImagesProductoRepository.deleteAll(productoUpdate.getListaImagenes());
				final Producto imagesProductoList = saveImages(producto);
		return responseGeneric;
	}

	@Override
	public ResponseGeneric<List<ProductoImagenesDto>> searchProducts(@PathVariable final int page,
																	 @PathVariable final int size) throws Exception {


		final Pageable pageable = PageRequest.of(page,size, Sort.by("id"));
		final Page<UploadImagesProducto> pageImagenes = this.iUploadImagesProductoRepository.findAll(pageable);

		final Page<Producto> listProducto = this.iProductoRepository.findAll(pageable);

		final List<ProductoImagenesDto> lista = listProducto.getContent().stream().map(m->{
			final ProductoImagenesDto productoImagenesDto = new ProductoImagenesDto();
			final List<ImagenDto> imagenDtoList = m.getListaImagenes().stream().map(mapp->{
				productoImagenesDto.setProducto(mapp.getProducto());
				productoImagenesDto.setId(mapp.getId());
				final ImagenDto imagenDto = new ImagenDto();
				imagenDto.setId(mapp.getId());
				imagenDto.setNombreImagen(mapp.getNombreImagen());
				imagenDto.setExtencionImagen(mapp.getFormatoDocumento().getExtencion());

				final String urlConcat = PATH.concat(NAME_FOLDER_PRODUCTOS);
				FileReader fr;
				BufferedReader br;
				final File files = new File(urlConcat).getAbsoluteFile();
				final Optional<File> exist = Arrays.stream(files.listFiles()).filter(f -> {
					final String divideCadena[] = f.getName().split("-");
					final String cadenaEncontrada = divideCadena[1].replace(".txt", "");
					return cadenaEncontrada.equals(String.valueOf(mapp.getId()));
				}).findFirst();
				if( exist.isPresent()){
					File existFile = exist.get();
					if (!existFile.isDirectory()) {
						try {
							fr = new FileReader(urlConcat.concat(NAME_BARRA).concat(existFile.getName()));
							br = new BufferedReader(fr);
							String linea;
							while ((linea = br.readLine()) != null)
								imagenDto.setBase64Imagen(linea);
							imagenDto.setNombreImagen(mapp.getNombreImagen());
							imagenDto.setExtencionImagen(mapp.getFormatoDocumento().getExtencion());

						} catch (FileNotFoundException e) {
							logger.error("Ocurrio un error, No se encontro el archivo.  {}  UploadDocumentoService, getImages ", e.getMessage());
							throw new RuntimeException("Ocurrio un error, el archivo no existe");
						} catch (IOException e) {
							logger.error("Ocurrio un error, IOException.  {}  UploadDocumentoService, getImages ", e.getMessage());
							throw new RuntimeException("Ocurrio un error al cargar las imagenes");
						}
					} else {
						logger.error("No existe  ");
					}
				}



				return  imagenDto;
			}).collect(Collectors.toList());
			productoImagenesDto.setImagenes(imagenDtoList);
			return productoImagenesDto;
		}).collect(Collectors.toList());

//	lista.stream().collect(Collectors.groupingBy(ProductoImagenesDto::getId));

//		final List<ProductoImagenesDto> lista = pageImagenes.getContent().stream().map(m->{
//			final ProductoImagenesDto productoImagenesDto = new ProductoImagenesDto();
//			productoImagenesDto.setProducto(m.getProducto());
//
//			final List<ImagenDto> imagenDtoList = m.getProducto().getListaImagenes().stream().map(mapp->{
//				final ImagenDto imagenDto = new ImagenDto();
//				imagenDto.setId(mapp.getId());
//				imagenDto.setNombreImagen(mapp.getNombreImagen());
//				imagenDto.setExtencionImagen(mapp.getFormatoDocumento().getExtencion());
//
//				final String urlConcat = urlDirectory.concat(NAME_BARRA).concat(NAME_FOLDER_PRODUCTOS);
//				FileReader fr;
//				BufferedReader br;
//				final File files = new File(urlConcat).getAbsoluteFile();
//				final Optional<File> exist = Arrays.stream(files.listFiles()).filter(f -> {
//					final String divideCadena[] = f.getName().split("-");
//					final String cadenaEncontrada = divideCadena[1].replace(".txt", "");
//					return cadenaEncontrada.equals(String.valueOf(mapp.getId()));
//				}).findFirst();
//				if( exist.isPresent()){
//					File existFile = exist.get();
//					if (!existFile.isDirectory()) {
//						try {
//							fr = new FileReader(urlConcat.concat(NAME_BARRA).concat(existFile.getName()));
//							br = new BufferedReader(fr);
//							String linea;
//							while ((linea = br.readLine()) != null)
//								imagenDto.setBase64Imagen(linea);
//							imagenDto.setNombreImagen(mapp.getNombreImagen());
//							imagenDto.setExtencionImagen(mapp.getFormatoDocumento().getExtencion());
//
//						} catch (FileNotFoundException e) {
//							logger.error("Ocurrio un error, No se encontro el archivo.  {}  UploadDocumentoService, getImages ", e.getMessage());
//							throw new RuntimeException("Ocurrio un error, el archivo no existe");
//						} catch (IOException e) {
//							logger.error("Ocurrio un error, IOException.  {}  UploadDocumentoService, getImages ", e.getMessage());
//							throw new RuntimeException("Ocurrio un error al cargar las imagenes");
//						}
//					} else {
//						logger.error("No existe  ");
//					}
//				}
//
//
//
//				return  imagenDto;
//			}).collect(Collectors.toList());
//
//			productoImagenesDto.setImagenes(imagenDtoList);
//			return productoImagenesDto;
//		}).collect(Collectors.toList() );


		logger.debug(" log {} ",	lista.stream().collect(Collectors.groupingBy(ProductoImagenesDto::getId)) );
		final Page<ProductoImagenesDto> corteDtoPage = new PageImpl<>(lista);
		final ResponseGeneric<List<ProductoImagenesDto> > responseGeneric = new ResponseGeneric<>();
		if( !corteDtoPage.isEmpty()){
			responseGeneric.setCode("200 OK");
			responseGeneric.setCodeValue(200);
			responseGeneric.setMensaje("Se encotraron registros");
			responseGeneric.setDatos(corteDtoPage.getContent());
		}
		return responseGeneric;
	}


	@Override
	public ResponseGeneric<Optional<ProductoImagenesDto>> findByIdProduct(@PathVariable final int id) throws Exception {
		final ProductoImagenesDto productoImagenesDto = new ProductoImagenesDto();
		final Optional<Producto> optionalProducto = this.iProductoRepository.findById(id);
		if( optionalProducto.isPresent()){
			final Producto producto = optionalProducto.get();
			final List<ImagenDto> imagenDtoList = producto.getListaImagenes().stream().map(mapp->{
				productoImagenesDto.setProducto(mapp.getProducto());
				productoImagenesDto.setId(producto.getId());
				final ImagenDto imagenDto = new ImagenDto();
				imagenDto.setId(mapp.getId());
				imagenDto.setNombreImagen(mapp.getNombreImagen());
				imagenDto.setExtencionImagen(mapp.getFormatoDocumento().getExtencion());

				final String urlConcat = urlDirectory.concat(NAME_BARRA).concat(NAME_FOLDER_PRODUCTOS);
				FileReader fr;
				BufferedReader br;
				final File files = new File(urlConcat).getAbsoluteFile();
				final Optional<File> exist = Arrays.stream(files.listFiles()).filter(f -> {
					final String divideCadena[] = f.getName().split("-");
					final String cadenaEncontrada = divideCadena[1].replace(".txt", "");
					return cadenaEncontrada.equals(String.valueOf(mapp.getId()));
				}).findFirst();
				if( exist.isPresent()){
					File existFile = exist.get();
					if (!existFile.isDirectory()) {
						try {
							fr = new FileReader(urlConcat.concat(NAME_BARRA).concat(existFile.getName()));
							br = new BufferedReader(fr);
							String linea;
							while ((linea = br.readLine()) != null)
								imagenDto.setBase64Imagen(linea);
							imagenDto.setNombreImagen(mapp.getNombreImagen());
							imagenDto.setExtencionImagen(mapp.getFormatoDocumento().getExtencion());

						} catch (FileNotFoundException e) {
							logger.error("Ocurrio un error, No se encontro el archivo.  {}  UploadDocumentoService, getImages ", e.getMessage());
							throw new RuntimeException("Ocurrio un error, el archivo no existe");
						} catch (IOException e) {
							logger.error("Ocurrio un error, IOException.  {}  UploadDocumentoService, getImages ", e.getMessage());
							throw new RuntimeException("Ocurrio un error al cargar las imagenes");
						}
					} else {
						logger.error("No existe  ");
					}
				}
				return  imagenDto;
			}).collect(Collectors.toList());
			productoImagenesDto.setProducto(producto);
			productoImagenesDto.setImagenes(imagenDtoList);
		}

		final ResponseGeneric<Optional<ProductoImagenesDto>> responseGeneric = new ResponseGeneric<>();
		if( productoImagenesDto != null ){
			responseGeneric.setCode("200 OK");
			responseGeneric.setCodeValue(200);
			responseGeneric.setMensaje("Se encotro el producto");
			responseGeneric.setDatos(Optional.of(productoImagenesDto));
		}
		return responseGeneric;
	}


}

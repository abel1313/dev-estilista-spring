package com.estilista.app.service_api;

import com.estilista.app.dto.CorteDto;
import com.estilista.app.dto.ImagenDto;
import com.estilista.app.dto.TipoCorteDto;
import com.estilista.app.dto.UploadDocumentoDto;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.TipoCorte;
import com.estilista.app.model.UploadDocumento;
import com.estilista.app.repositories.IUploadDocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.estilista.app.model.Corte;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.ICorteRepository;
import com.estilista.app.services.ICorteService;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CorteServiceImpl extends BaseServiceImpl<Corte, Integer>implements ICorteService {

	private ICorteRepository iCorteRepository;
	private IUploadDocumentsRepository iUploadDocumentsRepository;

	private ResponseGeneric<UploadDocumento> uploadDocumento;


	public CorteServiceImpl(final IBaseRepository<Corte, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public void setiCorteRepository(final ICorteRepository iCorteRepository) {
		this.iCorteRepository = iCorteRepository;
	}
	@Autowired
	public void setiUploadDocumentsRepository(final IUploadDocumentsRepository iUploadDocumentsRepository) {
		this.iUploadDocumentsRepository = iUploadDocumentsRepository;
	}

	@Override
	public ResponseGeneric<List<CorteDto> > getAllCortePageService(@PathVariable final int page,
															@PathVariable final int size) throws Exception {

		final Pageable pageable = PageRequest.of(page,size, Sort.by("id"));
		final Page<Corte> cortePage = this.iCorteRepository.findAll(pageable);

		final List<CorteDto> lista = cortePage.getContent().stream().map(m->{
			final CorteDto corteDto = new CorteDto();
				corteDto.setId(m.getId());
			final TipoCorteDto tipoCorteDto = new TipoCorteDto();
			final TipoCorte tipoCorte = m.getTipoCorte();
			tipoCorteDto.setId(tipoCorte.getId());
			tipoCorteDto.setNombreCorte(tipoCorte.getNombreCorte());
			tipoCorteDto.setPrecioTipoCorte(tipoCorte.getPrecioTipoCorte());
			corteDto.setTipoCorte(tipoCorteDto);
			final List<ImagenDto> imagenDtoList = m.getListaCortes().stream().map(mapp->{
				final ImagenDto imagenDto = new ImagenDto();
				imagenDto.setId(mapp.getId());
				imagenDto.setNombreImagen(mapp.getNombreImagen());
				imagenDto.setExtencionImagen(mapp.getExtencion());

				FileReader fr;
				BufferedReader br;
				final File files = new File(urlDirectory).getAbsoluteFile();
				final Optional<File> exist = Arrays.stream(files.listFiles()).filter(f -> {
					final String divideCadena[] = f.getName().split("-");
					final String cadenaEncontrada = divideCadena[1].replace(".txt", "");
					return cadenaEncontrada.equals(String.valueOf(mapp.getId()));
				}).findFirst();
				if( exist.isPresent()){
					File existFile = exist.get();
					if (!existFile.isDirectory()) {
						try {
							fr = new FileReader(urlDirectory + existFile.getName());
							br = new BufferedReader(fr);
							String linea;
							while ((linea = br.readLine()) != null)
								imagenDto.setBase64Imagen(linea);
							imagenDto.setNombreImagen(mapp.getNombreImagen());
							imagenDto.setExtencionImagen(mapp.getExtencion());

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
			corteDto.setImagenes(imagenDtoList);
			return corteDto;
		}).collect(Collectors.toList());
		final Page<CorteDto> corteDtoPage = new PageImpl<>(lista);
		final ResponseGeneric<List<CorteDto> > responseGeneric = new ResponseGeneric<>();
		if( !corteDtoPage.isEmpty()){
			responseGeneric.setCode("200 OK");
			responseGeneric.setCodeValue(200);
			responseGeneric.setMensaje("Se encotraron registros");
			responseGeneric.setDatos(corteDtoPage.getContent());
		}
		return responseGeneric;
	}

	@Override
	public ResponseGeneric<Boolean> saveCorte(UploadDocumentoDto uploadDocumentoDto) throws Exception {
		ResponseGeneric<Boolean> responseGeneric = new ResponseGeneric<>();
		// Get the file and save it somewhere
		final Corte corte = new Corte();
		corte.setId(uploadDocumentoDto.getId());
		final TipoCorteDto tipoCorteDto = uploadDocumentoDto.getTipoCorte();
		corte.setTipoCorte(new TipoCorte(tipoCorteDto.getNombreCorte(), tipoCorteDto.getPrecioTipoCorte()));
		final Corte responseGenericCorte = iCorteRepository.save(corte);

		if(Objects.nonNull(responseGenericCorte)	 ){
			File directorio = new File(urlDirectory).getAbsoluteFile();
			if (!directorio.exists()) {
				if (directorio.mkdirs()) {
					logger.info("Directorio creado");
				} else {
					logger.error("Error al crear directorio");
				}
			}
			try {
				uploadDocumentoDto.getImagenes().stream().forEach(f->{
					try {

						final UploadDocumento uploadDocumento1= this.iUploadDocumentsRepository.save(new UploadDocumento(f.getNombreImagen(),f.getExtencionImagen(),responseGenericCorte));
						FileWriter fw = new FileWriter(urlDirectory
								.concat(String.valueOf(new Date().getTime()))
								.concat("-")
								.concat(String.valueOf(uploadDocumento1.getId()))
								.concat(".txt"));
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(f.getBase64Imagen());
						bw.close();
					} catch (Exception e) {
						logger.error(" Ocurrio un error al escribir el documento UploadDocumentoService, upload {} ",e.getMessage());
						throw new RuntimeException(e);
					}
				});

				responseGeneric.setCode("200 OK");
				responseGeneric.setMensaje("Se registro el corte y se agregaron las imagenes");
				responseGeneric.setCodeValue(200);
				responseGeneric.setDatos(true);
			}catch (Exception e){
				logger.error(" Ocurrio un error al escribir el documento UploadDocumentoService, upload {} ",e.getMessage());
				throw new RuntimeException(e);
			}
		}else{
			responseGeneric.setCode("200 OK");
			responseGeneric.setMensaje("El corte no se pudo registrar correctamente");
			responseGeneric.setDatos(false);
		}
		return responseGeneric ;
	}

}

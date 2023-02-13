package com.estilista.app.service_api;

import com.estilista.app.dto.ImagenDto;
import com.estilista.app.dto.TipoCorteDto;
import com.estilista.app.dto.UploadDocumentoDto;
import com.estilista.app.model.Corte;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.TipoCorte;
import com.estilista.app.model.UploadDocumento;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.services.ICorteService;
import com.estilista.app.services.IUploadDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UploadDocumentoService extends BaseServiceImpl<UploadDocumento, Integer>implements IUploadDocumentoService {
    private final String urlDirectory = ".//src//main//resources//imagenes//";
    @Autowired
    private ICorteService iCorteService;
    private ResponseGeneric<UploadDocumento> uploadDocumento;

    @Autowired
    private IUploadDocumentoService iUploadDocumentoService;

    public UploadDocumentoService(IBaseRepository<UploadDocumento, Integer> iBaseRepository) {
        super(iBaseRepository);
    }


    @Override
    public ResponseGeneric<Boolean> upload(UploadDocumentoDto uploadDocumentoDto) throws Exception {
        ResponseGeneric<Boolean> responseGeneric = new ResponseGeneric<>();
        // Get the file and save it somewhere
        final Corte corte = new Corte();
        corte.setId(uploadDocumentoDto.getId());
        final TipoCorteDto tipoCorteDto = uploadDocumentoDto.getTipoCorte();
        corte.setTipoCorte(new TipoCorte(tipoCorteDto.getNombreCorte(), tipoCorteDto.getPrecioTipoCorte()));
        final ResponseGeneric<Corte> responseGenericCorte = iCorteService.save(corte);
        if( responseGeneric.getCodeValue() == 200 ){
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

                        final Corte corteSave = responseGenericCorte.getDatos();
                        this.uploadDocumento = iUploadDocumentoService.save(new UploadDocumento(f.getNombreImagen(),f.getExtencionImagen(),corteSave));
                        FileWriter fw = new FileWriter(urlDirectory
                                .concat(String.valueOf(new Date().getTime()))
                                .concat("-")
                                .concat(String.valueOf(uploadDocumento.getDatos().getId()))
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
            responseGeneric.setDatos(true);
        }
        return responseGeneric ;
    }

    @Override
    public ResponseGeneric<UploadDocumentoDto> getImages(@PathVariable final int id) throws Exception {
        final Optional<Corte> optionalCorte = this.iCorteService.getOne(id);
        final UploadDocumentoDto uploadDocumentoDto = new UploadDocumentoDto();
        final ResponseGeneric<UploadDocumentoDto> responseGeneric = new ResponseGeneric<>();
        if( optionalCorte.isPresent() ){
            final Corte corte = optionalCorte.get();
            uploadDocumentoDto.setId(corte.getId());
            final TipoCorte tipoCorte = corte.getTipoCorte() ;
            final TipoCorteDto tipoCorteDto = new TipoCorteDto();
            tipoCorteDto.setId(tipoCorte.getId());
            tipoCorteDto.setNombreCorte(tipoCorte.getNombreCorte());
            tipoCorteDto.setPrecioTipoCorte(tipoCorte.getPrecioTipoCorte());
            uploadDocumentoDto.setTipoCorte(tipoCorteDto);

            List<ImagenDto> lista = corte.getListaCortes().stream().map(m->{
                final ImagenDto imagenDto = new ImagenDto();

                FileReader fr;
                BufferedReader br;
                final File files =  new File(urlDirectory).getAbsoluteFile();
                final Optional<File> exist = Arrays.stream(files.listFiles()).filter(f-> {
                    final String divideCadena[] = f.getName().split("-");
                    final String cadenaEncontrada = divideCadena[1].replace(".txt","");
                    return cadenaEncontrada.equals(String.valueOf(m.getId()));
                }).findFirst();
                File existFile = exist.get();
                if (!existFile.isDirectory()) {
                    try {
                        fr = new FileReader (urlDirectory+existFile.getName());
                        br = new BufferedReader(fr);
                        String linea;
                        while((linea=br.readLine())!=null)
                            imagenDto.setBase64Imagen(linea);
                        imagenDto.setNombreImagen(m.getNombreImagen());
                        imagenDto.setExtencionImagen(m.getExtencion());

                    } catch (FileNotFoundException e) {
                        logger.error("Ocurrio un error, No se encontro el archivo.  {}  UploadDocumentoService, getImages ",e.getMessage());
                        throw new RuntimeException("Ocurrio un error, el archivo no existe");
                    } catch (IOException e) {
                        logger.error("Ocurrio un error, IOException.  {}  UploadDocumentoService, getImages ",e.getMessage());
                        throw new RuntimeException("Ocurrio un error al cargar las imagenes");
                    }
                } else {
                    logger.error("No existe  " );
                }

                return imagenDto;
            }).collect(Collectors.toList());
            uploadDocumentoDto.setImagenes(lista);
            responseGeneric.setMensaje("Se encotro el corte y las imagenes");
            responseGeneric.setCode("200 OK");
            responseGeneric.setCodeValue(200);
            responseGeneric.setDatos(uploadDocumentoDto);

        }else{
            responseGeneric.setMensaje("No se encotro el corte y las imagenes");
            responseGeneric.setCode("200 OK");
        }

        return responseGeneric;
    }
}

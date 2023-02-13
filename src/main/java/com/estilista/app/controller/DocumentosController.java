package com.estilista.app.controller;

import com.estilista.app.dto.ImagenDto;
import com.estilista.app.dto.TipoCorteDto;
import com.estilista.app.dto.UploadDocumentoDto;
import com.estilista.app.model.Corte;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.TipoCorte;
import com.estilista.app.model.UploadDocumento;
import com.estilista.app.services.ICorteService;
import com.estilista.app.services.IUploadDocumentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("proyecto/carga-documentos")
public class DocumentosController {
    private final Logger logger = LoggerFactory.getLogger(DocumentosController.class);


    private IUploadDocumentoService iUploadDocumentoService;
    private ICorteService iCorteService;

    private ResponseGeneric<UploadDocumento> uploadDocumento;

    @Autowired
    public void setiCorteService(final ICorteService iCorteService) {
        this.iCorteService = iCorteService;
    }
    @Autowired
    public void setiUploadDocumentoService(final IUploadDocumentoService iUploadDocumentoService) {
        this.iUploadDocumentoService = iUploadDocumentoService;
    }

    @PostMapping(value = "/saveCortes")
    public ResponseEntity<ResponseGeneric<Boolean>>saveCortes(@RequestBody final UploadDocumentoDto uploadDocumentoDto) throws Exception{
         ResponseGeneric<Boolean> responseGeneric = null;
        try{
            responseGeneric = this.iUploadDocumentoService.upload(uploadDocumentoDto);
            return ResponseEntity.status(HttpStatus.OK).body(responseGeneric);
        }catch (Exception e){
            logger.error(" {} ",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneric);
        }
    }

    @GetMapping(value = "/showImages/{id}")
    public ResponseEntity<ResponseGeneric<UploadDocumentoDto>>showCortes(@PathVariable final int id) throws Exception{
        ResponseGeneric<UploadDocumentoDto> responseGeneric = null;
        try{
            responseGeneric = this.iUploadDocumentoService.getImages(id);
            return ResponseEntity.status(HttpStatus.OK).body(responseGeneric);
        }catch (Exception e){
            logger.error(" {} ",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneric);
        }
    }


    @GetMapping(value = "/getAllPage/{page}/{size}")
    public ResponseEntity<ResponseGeneric<Page<UploadDocumento>>>getAllPage(@PathVariable final int page,@PathVariable final int size) throws Exception{
        ResponseGeneric<Page<UploadDocumento>> responseGeneric = new ResponseGeneric<>();
        try{
            responseGeneric = this.iUploadDocumentoService.getAllPag(page,size);
            return ResponseEntity.status(HttpStatus.OK).body(responseGeneric);
        }catch (Exception e){
            logger.error(" {} ",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneric);
        }
    }

/**
 *
 *     @GetMapping(value = "/upload")
 *     public ResponseEntity<?>upload(@RequestParam(name = "foto") MultipartFile file) throws IOException {
 *         // Get the file and save it somewhere
 *
 *         byte[] bytes = file.getBytes();
 *         String encodedString = Base64.getEncoder().encodeToString(bytes);
 *         File directorio = new File(urlDirectory).getAbsoluteFile();
 *         if (!directorio.exists()) {
 *             if (directorio.mkdirs()) {
 *                 System.out.println("Directorio creado");
 *             } else {
 *                 System.out.println("Error al crear directorio");
 *             }
 *         }
 * try {
 *
 *      this.uploadDocumento = iUploadDocumentoService.save(new UploadDocumento("eje","jpg"));
 *
 *     FileWriter fw = new FileWriter(urlDirectory.concat(String.valueOf(uploadDocumento.getDatos().getId())).concat(".txt"));
 *     BufferedWriter bw = new BufferedWriter(fw);
 *     bw.write(encodedString);
 *     bw.close();
 * }catch (Exception e){
 *     System.out.println(e.getMessage());
 * }
 *
 *
 *         return null;
 *     }
 *
 *
 *     @PostMapping(value = "/uploadDocuments")
 *     public ResponseEntity<?>uploadImg(@RequestBody final UploadDocumentoDto uploadDocumentoDto) throws Exception {
 *         // Get the file and save it somewhere
 *         final Corte corte = new Corte();
 *         corte.setId(uploadDocumentoDto.getId());
 *         final TipoCorteDto tipoCorteDto = uploadDocumentoDto.getTipoCorte();
 *         corte.setTipoCorte(new TipoCorte(tipoCorteDto.getNombreCorte(), tipoCorteDto.getPrecioTipoCorte()));
 *         final ResponseGeneric<Corte> responseGenericCorte = iCorteService.save(corte);
 *
 *         File directorio = new File(urlDirectory).getAbsoluteFile();
 *         if (!directorio.exists()) {
 *             if (directorio.mkdirs()) {
 *                 System.out.println("Directorio creado");
 *             } else {
 *                 System.out.println("Error al crear directorio");
 *             }
 *         }
 *         try {
 *             uploadDocumentoDto.getImagenes().stream().forEach(f->{
 *                 try {
 *
 *                     final Corte corteSave = responseGenericCorte.getDatos();
 *                     this.uploadDocumento = iUploadDocumentoService.save(new UploadDocumento(f.getNombreImagen(),f.getExtencionImagen(),corteSave));
 *                     FileWriter fw = new FileWriter(urlDirectory
 *                             .concat(String.valueOf(new Date().getTime()))
 *                             .concat("-")
 *                             .concat(String.valueOf(uploadDocumento.getDatos().getId()))
 *                             .concat(".txt"));
 *                     BufferedWriter bw = new BufferedWriter(fw);
 *                     bw.write(f.getBase64Imagen());
 *                     bw.close();
 *                 } catch (Exception e) {
 *                     throw new RuntimeException(e);
 *                 }
 *             });
 *
 *
 *         }catch (Exception e){
 *             System.out.println(e.getMessage());
 *         }
 *
 *
 *         return null;
 *     }
 *
 * */
/**
 * @GetMapping(value = "/{id}")
 * public ResponseEntity<?>getDocument(@PathVariable int id) throws IOException {
 * FileReader fr = null;
 * BufferedReader br;
 * final UploadDocumentoDto uploadDocumentoDto = new UploadDocumentoDto();
 * try {
 * <p>
 * final Optional<UploadDocumento> optionalUploadDocumento = iUploadDocumentoService.getOne(id);
 * if( optionalUploadDocumento.isPresent()){
 * final UploadDocumento documentoEncontrado = optionalUploadDocumento.get();
 * final File files =  new File(urlDirectory).getAbsoluteFile();
 * final Optional<File> exist = Arrays.stream(files.listFiles()).filter(f-> {
 * final String cadena = f.getName().replace(".txt","");
 * return cadena.equals(String.valueOf(optionalUploadDocumento.get().getId()));
 * }).findFirst();
 * File existFile = exist.get();
 * if (!existFile.isDirectory()) {
 * <p>
 * <p>
 * fr = new FileReader (urlDirectory+optionalUploadDocumento.get().getId()+".txt");
 * br = new BufferedReader(fr);
 * String linea;
 * while((linea=br.readLine())!=null)
 * uploadDocumentoDto.setBase64(linea);
 * uploadDocumentoDto.setNombreImagen(documentoEncontrado.getNombreImagen());
 * uploadDocumentoDto.setExtencion(documentoEncontrado.getExtencion());
 * uploadDocumentoDto.setId(documentoEncontrado.getId());
 * } else {
 * System.out.println(" No existe ");
 * }
 * }
 * <p>
 * }catch (Exception e){
 * System.out.println(e.getMessage());
 * }finally{
 * // En el finally cerramos el fichero, para asegurarnos
 * // que se cierra tanto si todo va bien como si salta
 * // una excepcion.
 * try{
 * if( null != fr ){
 * fr.close();
 * }
 * }catch (Exception e2){
 * e2.printStackTrace();
 * }
 * }
 * <p>
 * <p>
 * return ResponseEntity.status(HttpStatus.OK).body(uploadDocumentoDto);
 * }
 */



/**
 *
 @GetMapping(value = "getData/{id}")
 public ResponseEntity<?> getImagenes(@PathVariable final int id) throws Exception {
 final Optional<Corte> optionalCorte = this.iCorteService.getOne(id);
 final UploadDocumentoDto uploadDocumentoDto = new UploadDocumentoDto();

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
 final String name = f.getName();
 final String cadena = f.getName().replace(".txt","");
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

 throw new RuntimeException(e);
 } catch (IOException e) {
 throw new RuntimeException(e);
 }

 } else {
 System.out.println(" No existe ");
 }




 return imagenDto;
 }).collect(Collectors.toList());
 uploadDocumentoDto.setImagenes(lista);
 }

 return ResponseEntity.status(HttpStatus.OK).body(uploadDocumentoDto);
 }

  * **/

}

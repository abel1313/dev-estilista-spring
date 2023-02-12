package com.estilista.app.controller;

import com.estilista.app.dto.UploadDocumentoDto;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.UploadDocumento;
import com.estilista.app.services.IUploadDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import java.util.Scanner;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("proyecto/carga-documentos")
public class DocumentosController {

    @Autowired
    private IUploadDocumentoService iUploadDocumentoService;

    private ResponseGeneric<UploadDocumento> uploadDocumento;
    private final String urlDirectory = ".//src//main//resources//imagenes//";
    @GetMapping(value = "/upload")
    public ResponseEntity<?>upload(@RequestParam(name = "foto") MultipartFile file) throws IOException {
        // Get the file and save it somewhere

        byte[] bytes = file.getBytes();
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        File directorio = new File(urlDirectory).getAbsoluteFile();
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
try {

     this.uploadDocumento = iUploadDocumentoService.save(new UploadDocumento("eje","jpg"));

    FileWriter fw = new FileWriter(urlDirectory.concat(String.valueOf(uploadDocumento.getDatos().getId())).concat(".txt"));
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(encodedString);
    bw.close();
}catch (Exception e){
    System.out.println(e.getMessage());
}


        return null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?>getDocument(@PathVariable int id) throws IOException {
        FileReader fr = null;
        BufferedReader br;
        final UploadDocumentoDto uploadDocumentoDto = new UploadDocumentoDto();
        try {

            final Optional<UploadDocumento> optionalUploadDocumento = iUploadDocumentoService.getOne(id);
            if( optionalUploadDocumento.isPresent()){
                final UploadDocumento documentoEncontrado = optionalUploadDocumento.get();
                final File files =  new File(urlDirectory).getAbsoluteFile();
                final Optional<File> exist = Arrays.stream(files.listFiles()).filter(f-> {
                    final String cadena = f.getName().replace(".txt","");
                    return cadena.equals(String.valueOf(optionalUploadDocumento.get().getId()));
                }).findFirst();
                File existFile = exist.get();
                    if (!existFile.isDirectory()) {


                        fr = new FileReader (urlDirectory+optionalUploadDocumento.get().getId()+".txt");
                        br = new BufferedReader(fr);
                        String linea;
                        while((linea=br.readLine())!=null)
                            uploadDocumentoDto.setBase64(linea);
                            uploadDocumentoDto.setNombreImagen(documentoEncontrado.getNombreImagen());
                            uploadDocumentoDto.setExtencion(documentoEncontrado.getExtencion());
                            uploadDocumentoDto.setId(documentoEncontrado.getId());
                    } else {
                        System.out.println(" No existe ");
                    }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }


        return ResponseEntity.status(HttpStatus.OK).body(uploadDocumentoDto);
    }
}

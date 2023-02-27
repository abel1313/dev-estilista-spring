package com.estilista.app.config;

import com.estilista.app.model.ImagenTemporal;
import com.estilista.app.services.IIMagenTemporalService;
import com.estilista.app.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
@EnableAsync
@EnableScheduling
public class ConfiguracionBeans {
    protected final String PATH_PRODUCTOS = Util.PATH_DIRECTORY.concat(Util.NAME_FOLDER_PRODUCTOS);
    @Autowired
    private IIMagenTemporalService iIMagenTemporalService;
    private final Logger logger = LoggerFactory.getLogger(ConfiguracionBeans.class);
    @Scheduled(cron = "0 0 18 * * ?")
    public void doSomething() throws Exception {
        final String hi = "gola";
        final List<ImagenTemporal> imagenTemporals = iIMagenTemporalService
                                                            .getAllImages()
                                                            .stream()
                                                            .filter(f->f.getNombreProducto().equals("producto"))
                                                            .limit(1)
                                                            .collect(Collectors.toList());
        final List<Integer> listIds = imagenTemporals.stream().map(m->m.getIdImagen()).collect(Collectors.toList());
        if( !imagenTemporals.isEmpty()){
            deletePath(listIds);
            iIMagenTemporalService.deleteAllImages(imagenTemporals);
        }
//        iIMagenTemporalService.delete()
        logger.debug(" debugeando thread {} ",imagenTemporals);
        System.out.println(" aqui vamos "+ imagenTemporals);
    }

    private void deletePath(final List<Integer> listIds){
        final File files = new File(PATH_PRODUCTOS).getAbsoluteFile();

        listIds.forEach(fo->{
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

}

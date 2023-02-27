package com.estilista.app.service_api;

import com.estilista.app.dto.ImagenDto;
import com.estilista.app.dto.UploadImagesProductoDto;
import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.FormatoDocumento;
import com.estilista.app.model.Producto;
import com.estilista.app.model.ResponseGeneric;
import com.estilista.app.model.UploadImagesProducto;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.IImagenRepository;
import com.estilista.app.repositories.IProductoRepository;
import com.estilista.app.repositories.IUploadImagesProductoRepository;
import com.estilista.app.services.IFormatoDocumentoService;
import com.estilista.app.services.IIMagenTemporalService;
import com.estilista.app.services.IProductoService;
import com.estilista.app.services.IUploadImagesPrductoService;
import com.estilista.app.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseImagenesAbstract extends BaseServiceImpl<Producto, Integer>implements IProductoService {

    @Autowired
    protected IFormatoDocumentoService iFormatoDocumentoService;
    @Autowired
    protected IUploadImagesPrductoService iUploadImagesPrductoService;

    @Autowired
    protected IProductoRepository iProductoRepository;

    @Autowired
    protected IIMagenTemporalService iiMagenTemporalService;

    @Autowired
    protected IImagenRepository iImagenRepository;

    protected final String NAME_FOLDER_PRODUCTOS = "productos";
    protected final String NAME_BARRA = "//";

    protected final String PATH_PRODUCTOS =  urlDirectory.concat(NAME_FOLDER_PRODUCTOS);

    @Autowired
    protected IUploadImagesProductoRepository iUploadImagesProductoRepository;

    public BaseImagenesAbstract(IBaseRepository<Producto, Integer> iBaseRepository) {
        super(iBaseRepository);
    }

    public List<ImagenDto> convertImagenes(List<ImagenDto> imagenes){
        return imagenes.stream().map(m->{
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
    }

    public Producto saveImages(@RequestBody final UploadImagesProductoDto producto){
        final Producto per =iProductoRepository.save( producto.getProducto());
        final List<ImagenDto> listImg = convertImagenes(producto.getList());
       List<UploadImagesProducto> upL = listImg.stream().map(sa->{
            ResponseGeneric<UploadImagesProducto> saveImg;
            try {
                final FormatoDocumento f = new FormatoDocumento();
                f.setId(Integer.parseInt(sa.getExtencionImagen()));
                saveImg = iUploadImagesPrductoService
                        .save(new UploadImagesProducto(sa.getNombreImagen(),
                                f,per));
                final FileWriter fw = new FileWriter(Util.PATH_DIRECTORY.concat(Util.NAME_FOLDER_PRODUCTOS)
                        .concat(Util.NAME_BARRA)
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
            return saveImg.getDatos();
        }).collect(Collectors.toList());
        per.setListaImagenes(upL);
       return per;
    }
}

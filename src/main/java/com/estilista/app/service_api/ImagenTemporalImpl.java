package com.estilista.app.service_api;

import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.ImagenTemporal;
import com.estilista.app.repositories.IBaseRepository;
import com.estilista.app.repositories.IImagenRepository;
import com.estilista.app.services.IIMagenTemporalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenTemporalImpl extends BaseServiceImpl<ImagenTemporal, Integer>implements IIMagenTemporalService {
    private IImagenRepository iImagenRepository;
    public ImagenTemporalImpl(IBaseRepository<ImagenTemporal, Integer> iBaseRepository) {
        super(iBaseRepository);
    }

    @Autowired
    public void setiImagenRepository(final IImagenRepository iImagenRepository) {
        this.iImagenRepository = iImagenRepository;
    }

    @Override
    public List<ImagenTemporal> getAllImages() throws ResourceNotFoundException {
        return this.iImagenRepository.findAll();
    }
    @Override
    public void deleteAllImages(final List<ImagenTemporal> imagenTemporalList)throws ResourceNotFoundException {
        this.iImagenRepository.deleteAll(imagenTemporalList);
    }
}

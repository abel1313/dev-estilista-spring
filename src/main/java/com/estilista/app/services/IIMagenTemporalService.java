package com.estilista.app.services;

import com.estilista.app.exception.ResourceNotFoundException;
import com.estilista.app.model.ImagenTemporal;

import java.util.List;

public interface IIMagenTemporalService extends IBaseService<ImagenTemporal, Integer>{

    List<ImagenTemporal> getAllImages() throws ResourceNotFoundException;
    void deleteAllImages(final List<ImagenTemporal> imagenTemporalList)throws ResourceNotFoundException;
}

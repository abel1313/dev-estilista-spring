package com.estilista.app.repositories;

import com.estilista.app.model.ImagenTemporal;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagenRepository extends IBaseRepository<ImagenTemporal, Integer> {
}

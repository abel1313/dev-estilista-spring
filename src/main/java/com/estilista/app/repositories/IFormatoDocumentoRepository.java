package com.estilista.app.repositories;

import com.estilista.app.model.FormatoDocumento;
import com.estilista.app.model.Producto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface IFormatoDocumentoRepository extends IBaseRepository<FormatoDocumento, Integer> {

    Optional<FormatoDocumento>findByExtencion(@Param("extemcion") final String extencion);
}

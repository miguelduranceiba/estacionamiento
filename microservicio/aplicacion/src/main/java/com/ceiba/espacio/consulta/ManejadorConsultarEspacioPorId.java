package com.ceiba.espacio.consulta;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.puerto.dao.DaoEspacio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarEspacioPorId {

    private final DaoEspacio daoEspacio;

    public ManejadorConsultarEspacioPorId(DaoEspacio daoEspacio) {
        this.daoEspacio = daoEspacio;
    }

    public DtoEspacio ejecutar(long id) {
        return daoEspacio.consultarPorId(id);
    }
}

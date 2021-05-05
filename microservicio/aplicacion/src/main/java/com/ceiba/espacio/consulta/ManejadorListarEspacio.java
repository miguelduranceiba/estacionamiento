package com.ceiba.espacio.consulta;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.puerto.dao.DaoEspacio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEspacio {

    private final DaoEspacio daoEspacio;

    public ManejadorListarEspacio(DaoEspacio daoEspacio) {
        this.daoEspacio = daoEspacio;
    }

    public List<DtoEspacio> ejecutar() {
        return daoEspacio.listar();
    }
}

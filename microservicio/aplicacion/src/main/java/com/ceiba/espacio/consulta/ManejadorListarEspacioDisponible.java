package com.ceiba.espacio.consulta;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.puerto.dao.DaoEspacio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEspacioDisponible {

    private final DaoEspacio daoEspacio;

    public ManejadorListarEspacioDisponible(DaoEspacio daoEspacio) {
        this.daoEspacio = daoEspacio;
    }

    public List<DtoEspacio> ejecutar() {
        return daoEspacio.listarEspacioDisponible();
    }
}

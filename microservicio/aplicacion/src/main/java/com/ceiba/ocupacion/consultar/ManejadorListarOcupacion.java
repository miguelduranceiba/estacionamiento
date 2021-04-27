package com.ceiba.ocupacion.consultar;

import com.ceiba.ocupacion.modelo.dto.DtoOcupacion;
import com.ceiba.ocupacion.puerto.dao.DaoOcupacion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarOcupacion {

    private final DaoOcupacion daoOcupacion;

    public ManejadorListarOcupacion(DaoOcupacion daoOcupacion) {
        this.daoOcupacion = daoOcupacion;
    }

    public List<DtoOcupacion> ejecutar() {
        return this.daoOcupacion.listar();
    }
}

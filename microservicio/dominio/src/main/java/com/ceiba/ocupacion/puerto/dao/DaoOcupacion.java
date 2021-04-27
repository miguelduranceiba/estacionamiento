package com.ceiba.ocupacion.puerto.dao;

import com.ceiba.ocupacion.modelo.dto.DtoOcupacion;

import java.util.List;

public interface DaoOcupacion {

    /**
     * Permite consultar el historial de las ocupaciones
     *
     * @return
     */
    List<DtoOcupacion> listar();

}

package com.ceiba.espacio.puerto.dao;

import com.ceiba.espacio.modelo.dto.DtoEspacio;

import java.util.List;

public interface DaoEspacio {

    /**
     * Permite listar solo los espacios disponibles
     *
     * @return
     */
    List<DtoEspacio> listarEspacioActivo();

    /**
     * Permite listar los espacios
     *
     * @return
     */
    List<DtoEspacio> listar();

    /**
     * Permite consultar el espacio por id
     *
     * @param id
     * @return
     */
    DtoEspacio consultarPorId(long id);

}

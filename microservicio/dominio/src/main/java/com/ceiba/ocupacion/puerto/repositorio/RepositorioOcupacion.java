package com.ceiba.ocupacion.puerto.repositorio;

import com.ceiba.ocupacion.modelo.dto.DtoOcupacion;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;

import java.time.LocalDateTime;

public interface RepositorioOcupacion {

    /**
     * Permite crear una ocupación
     *
     * @param ocupacion
     * @return
     */
    Long crear(Ocupacion ocupacion);

    /**
     * Permite validar si un espacio ha sido ocupado
     *
     * @param id
     * @return
     */
    boolean existeEspacioPorId(long id);

    /**
     * Permite pagar el servicio de parqueo
     *
     * @param ocupacion
     */
    void pagar(Ocupacion ocupacion);

    /**
     * Permite consultar una ocupación por id
     *
     * @param id
     * @return
     */
    Ocupacion consultarPorId(long id);
}

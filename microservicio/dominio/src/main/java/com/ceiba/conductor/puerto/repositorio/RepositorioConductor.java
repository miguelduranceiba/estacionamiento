package com.ceiba.conductor.puerto.repositorio;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public interface RepositorioConductor {

    /**
     * Permite crear un conductor
     *
     * @param conductor
     * @return el id generado
     */
    Long crear(Conductor conductor);

    /**
     * Permite validar si el conductor existe por tipo y número de identificación
     *
     * @param tipoIdentificacion
     * @param numeroIdentificacion
     * @return
     */
    boolean existe(String tipoIdentificacion, String numeroIdentificacion);

    /**
     * Permite actualizar la información del conductor
     *
     * @param conductor
     * @return
     */
    int actualizar(Conductor conductor);

    /**
     * Permite validar que un tipo y número de identificación se encuentren asociados a otro conductor
     *
     * @param id
     * @param tipoIdentificacion
     * @param numeroIdentificacion
     * @return
     */
    boolean existeExcluyendoId(Long id, String tipoIdentificacion, String numeroIdentificacion);

    /**
     * Permite consultar el conductor por id
     *
     * @param id
     * @return
     */
    Conductor consultarPorId(long id);
}

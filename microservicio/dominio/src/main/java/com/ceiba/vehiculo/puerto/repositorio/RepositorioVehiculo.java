package com.ceiba.vehiculo.puerto.repositorio;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {

    /**
     * Permite crear un vehiculo
     *
     * @param usuario
     * @return el id generado
     */
    Long crear(Vehiculo usuario);

    /**
     * Permite validar si existe un vehiculo con una placa
     *
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);

    /**
     * Permite consultar un vehículo por id
     *
     * @param id
     * @return
     */
    Vehiculo consultarPorId(long id);
}

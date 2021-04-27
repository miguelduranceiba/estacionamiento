package com.ceiba.tipoVehiculo.puerto.repositorio;

import com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo;

public interface RepositorioTipoVehiculo {

    /**
     * Permite consultar el tipo de vehículo por id
     *
     * @param id
     * @return
     */
    TipoVehiculo consultarPorId(long id);
}

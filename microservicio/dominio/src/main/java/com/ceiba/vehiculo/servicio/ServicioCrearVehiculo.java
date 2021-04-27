package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

    public static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehículo ya existe en el sistema";
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public Long ejecutar(Vehiculo vehiculo) {
        validarExistenciaPrevia(vehiculo);
        return this.repositorioVehiculo.crear(vehiculo);
    }

    private void validarExistenciaPrevia(Vehiculo vehiculo) {
        boolean existe = this.repositorioVehiculo.existe(vehiculo.getPlaca());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}

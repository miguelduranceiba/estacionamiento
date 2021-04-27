package com.ceiba.conductor.servicio;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearConductor {

    public static final String EL_CONDUCTOR_YA_EXISTE = "El conductor ya existe en el sistema";
    private final RepositorioConductor repositorioConductor;

    public ServicioCrearConductor(RepositorioConductor repositorioConductor) {
        this.repositorioConductor = repositorioConductor;
    }

    public Long ejecutar(Conductor conductor) {
        validarExisteConductor(conductor);
        return repositorioConductor.crear(conductor);
    }

    private void validarExisteConductor(Conductor conductor) {
        boolean existe = repositorioConductor.existe(conductor.getTipoIdentificacion(), conductor.getNumeroIdentificacion());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_CONDUCTOR_YA_EXISTE);
        }
    }
}

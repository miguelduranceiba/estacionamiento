package com.ceiba.conductor.servicio;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ServicioActualizarConductor {

    private static final String EL_CONDUCTOR_YA_EXISTE_EN_EL_SISTEMA = "El tipo y número de identificación estan asociados a otro conductor";
    private final RepositorioConductor repositorioConductor;

    public ServicioActualizarConductor(RepositorioConductor repositorioConductor) {
        this.repositorioConductor = repositorioConductor;
    }

    public int ejecutar(Conductor conductor) {
        validarExistenciaPrevia(conductor);
        return this.repositorioConductor.actualizar(conductor);
    }

    private void validarExistenciaPrevia(Conductor conductor) {
        boolean existe = this.repositorioConductor.existeExcluyendoId(conductor.getId(), conductor.getTipoIdentificacion(), conductor.getNumeroIdentificacion());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_CONDUCTOR_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}

package com.ceiba.ocupacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;

public class ServicioCrearOcupacion {

    public static final String EL_ESPACIO_ESTA_OCUPADO = "El espacio esta ocupado";
    private final RepositorioOcupacion repositorioOcupacion;
    private final RepositorioEspacio repositorioEspacio;

    public ServicioCrearOcupacion(RepositorioOcupacion repositorioOcupacion, RepositorioEspacio repositorioEspacio) {
        this.repositorioOcupacion = repositorioOcupacion;
        this.repositorioEspacio = repositorioEspacio;
    }

    public Long ejecutar(Ocupacion ocupacion) {
        validarExisteOcuapcion(ocupacion);
        long idOcupacion = this.repositorioOcupacion.crear(ocupacion);
        repositorioEspacio.actualizarEstado(ocupacion.getEspacio().getId(), EstadoEspacio.OCUPADO.id());
        return idOcupacion;
    }

    private void validarExisteOcuapcion(Ocupacion ocupacion) {
        boolean existe = repositorioEspacio.estadoEspacio(ocupacion.getEspacio().getId(), EstadoEspacio.OCUPADO.id());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_ESPACIO_ESTA_OCUPADO);
        }
    }
}

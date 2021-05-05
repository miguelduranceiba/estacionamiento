package com.ceiba.ocupacion.servicio;

import com.ceiba.diaFestivo.puerto.repositorio.RepositorioFestivo;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;

public class ServicioPagarOcupacion {

    private final RepositorioOcupacion repositorioOcupacion;
    private final RepositorioEspacio repositorioEspacio;
    private final RepositorioFestivo repositorioFestivo;

    public ServicioPagarOcupacion(RepositorioOcupacion repositorioOcupacion, RepositorioEspacio repositorioEspacio, RepositorioFestivo repositorioFestivo) {
        this.repositorioOcupacion = repositorioOcupacion;
        this.repositorioEspacio = repositorioEspacio;
        this.repositorioFestivo = repositorioFestivo;
    }

    public void ejecutar(long idOcupacion) {
        Ocupacion ocupacion = repositorioOcupacion.consultarPorId(idOcupacion);

        ocupacion.finalizar(repositorioFestivo.listar());

        repositorioEspacio.actualizarEstado(ocupacion.getEspacio().getId(), EstadoEspacio.DISPONIBLE.id());

        this.repositorioOcupacion.pagar(ocupacion);
    }
}

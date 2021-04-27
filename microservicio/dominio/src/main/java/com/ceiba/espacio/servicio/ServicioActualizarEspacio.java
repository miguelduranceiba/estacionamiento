package com.ceiba.espacio.servicio;

import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;

public class ServicioActualizarEspacio {

    private final RepositorioEspacio repositorioEspacio;

    public ServicioActualizarEspacio(RepositorioEspacio repositorioEspacio) {
        this.repositorioEspacio = repositorioEspacio;
    }

    public int ejecutar(Espacio espacio) {
        return this.repositorioEspacio.actualizar(espacio);
    }
}

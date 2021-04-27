package com.ceiba.espacio.servicio;

import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;

public class ServicioCrearEspacio {

    private final RepositorioEspacio repositorioEspacio;

    public ServicioCrearEspacio(RepositorioEspacio repositorioEspacio) {
        this.repositorioEspacio = repositorioEspacio;
    }

    public Long ejecutar(Espacio espacio) {
        return this.repositorioEspacio.crear(espacio);
    }
}

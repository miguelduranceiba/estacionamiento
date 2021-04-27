package com.ceiba.espacio.servicio;

import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;

public class ServicioInactivarEspacio {

    private final RepositorioEspacio repositorioEspacio;

    public ServicioInactivarEspacio(RepositorioEspacio repositorioEspacio) {
        this.repositorioEspacio = repositorioEspacio;
    }

    public void ejecutar(long id) {
        this.repositorioEspacio.inactivar(id);
    }

}

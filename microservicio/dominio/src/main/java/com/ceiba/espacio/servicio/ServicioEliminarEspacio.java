package com.ceiba.espacio.servicio;

import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;

public class ServicioEliminarEspacio {

    public static final String EL_ESPACIO_NO_SE_PUEDE_ELIMINAR_SE_PUEDE_INACTIVAR = "El espacio ha sido utilizado en ocasiones anteriores.";
    private final RepositorioEspacio repositorioEspacio;
    private final RepositorioOcupacion repositorioOcupacion;

    public ServicioEliminarEspacio(RepositorioEspacio repositorioEspacio, RepositorioOcupacion repositorioOcupacion) {
        this.repositorioEspacio = repositorioEspacio;
        this.repositorioOcupacion = repositorioOcupacion;
    }

    public void ejecutar(long id) {
        validarEspacioHaSidoOcupado(id);
        this.repositorioEspacio.eliminar(id);
    }

    private void validarEspacioHaSidoOcupado(long id) {
        boolean existe = repositorioOcupacion.existeEspacioPorId(id);
        if (existe) {
            throw new RuntimeException(EL_ESPACIO_NO_SE_PUEDE_ELIMINAR_SE_PUEDE_INACTIVAR);
        }
    }

}

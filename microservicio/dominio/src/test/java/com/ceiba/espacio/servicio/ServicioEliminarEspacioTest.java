package com.ceiba.espacio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarEspacioTest {

    @Test
    public void validarEliminarEspacioExistente() {
        Long id = 1L;

        RepositorioOcupacion repositorioOcupacion = Mockito.mock(RepositorioOcupacion.class);
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        Mockito.when(repositorioOcupacion.existeEspacioPorId(id)).thenReturn(true);
        ServicioEliminarEspacio servicioEliminarEspacio = new ServicioEliminarEspacio(repositorioEspacio, repositorioOcupacion);

        BasePrueba.assertThrows(() -> servicioEliminarEspacio.ejecutar(id), RuntimeException.class, ServicioEliminarEspacio.EL_ESPACIO_NO_SE_PUEDE_ELIMINAR_SE_PUEDE_INACTIVAR);
    }

    @Test
    public void validarEliminarNoExistente() {
        Long id = 1L;

        RepositorioOcupacion repositorioOcupacion = Mockito.mock(RepositorioOcupacion.class);
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        ServicioEliminarEspacio servicioEliminarEspacio = new ServicioEliminarEspacio(repositorioEspacio, repositorioOcupacion);

        BasePrueba.assertValid(() -> servicioEliminarEspacio.ejecutar(id));
    }

}

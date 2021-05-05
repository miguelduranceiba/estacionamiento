package com.ceiba.ocupacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;
import com.ceiba.ocupacion.servicio.testdatabuilder.OcupacionTestDataBuilder;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearOcupacionTest {

    @Test
    public void validarExistenciaOcupacionEspacio() {
        Long idEspacio = 1L;
        EspacioTestDataBuilder espacio = new EspacioTestDataBuilder().conId(idEspacio).conEstado(EstadoEspacio.OCUPADO.id());
        Ocupacion ocupacion = new OcupacionTestDataBuilder().conEspacio(espacio).build();

        RepositorioOcupacion repositorioOcupacion = Mockito.mock(RepositorioOcupacion.class);
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);

        Mockito.when(repositorioEspacio.estadoEspacio(idEspacio, EstadoEspacio.OCUPADO.id())).thenReturn(true);

        ServicioCrearOcupacion servicioCrearOcupacion = new ServicioCrearOcupacion(repositorioOcupacion, repositorioEspacio, repositorioReserva);

        BasePrueba.assertThrows(() -> servicioCrearOcupacion.ejecutar(ocupacion), ExcepcionDuplicidad.class, ServicioCrearOcupacion.EL_ESPACIO_ESTA_OCUPADO);
    }

    @Test
    public void validarCreacionExistosaOcupacion() {

        Ocupacion ocupacion = new OcupacionTestDataBuilder().build();

        RepositorioOcupacion repositorioOcupacion = Mockito.mock(RepositorioOcupacion.class);
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);

        ServicioCrearOcupacion servicioCrearOcupacion = new ServicioCrearOcupacion(repositorioOcupacion, repositorioEspacio, repositorioReserva);

        BasePrueba.assertValid(() -> servicioCrearOcupacion.ejecutar(ocupacion));
    }
}

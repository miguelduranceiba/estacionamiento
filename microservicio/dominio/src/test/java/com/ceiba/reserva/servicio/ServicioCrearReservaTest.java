package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioCrearReservaTest {

    @Test
    public void validarCrearReserva() {
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaFin = LocalDateTime.now();

        Reserva reserva = new ReservaTestDataBuilder().conFechaInicio(fechaInicio).conFechaFin(fechaFin).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(fechaInicio, fechaFin)).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);

        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, ServicioCrearReserva.YA_EXISTE_UNA_RESERVA_PARA_EL_RANGO_TIEMPO);
    }

}

package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
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

    @Test
    public void validarExcepcionFechaDiferente() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 01, 01, 01, 00, 00);
        LocalDateTime fechaFin = LocalDateTime.of(2021, 02, 01, 01, 00, 00);

        Reserva reserva = new ReservaTestDataBuilder().conFechaInicio(fechaInicio).conFechaFin(fechaFin).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);

        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "El rango de la reserva debe ser en el mismo día");
    }

    @Test
    public void validarFinDeSemana() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 5, 8, 0, 0, 0);
        LocalDateTime fechaFin = LocalDateTime.of(2021, 5, 8, 1, 0, 0);

        Reserva reserva = new ReservaTestDataBuilder().conFechaInicio(fechaInicio).conFechaFin(fechaFin).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);

        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "No se pueden hacer reservas los sábados y domingos");
    }

    @Test
    public void validarFechaDiferenteResultadoValido() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 1, 1, 1, 0, 0);
        LocalDateTime fechaFin = LocalDateTime.of(2021, 1, 1, 9, 0, 0);

        Reserva reserva = new ReservaTestDataBuilder().conFechaInicio(fechaInicio).conFechaFin(fechaFin).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);

        BasePrueba.assertValid(() -> servicioCrearReserva.ejecutar(reserva));
    }

}

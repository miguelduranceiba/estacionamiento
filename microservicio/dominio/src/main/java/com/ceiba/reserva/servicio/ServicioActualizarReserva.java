package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.time.LocalDateTime;

public class ServicioActualizarReserva {

    private static final String YA_EXISTE_UNA_RESERVA = "Ya existe una reserva en el sistema";
    private final RepositorioReserva repositorioReserva;

    public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public int ejecutar(Reserva reserva) {
        validarNoExistaReserva(reserva.getId(), reserva.getFechaInicio(), reserva.getFechaFin());
        return this.repositorioReserva.actualizar(reserva);
    }

    private void validarNoExistaReserva(long id, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        boolean existe = repositorioReserva.existenciaId(id, fechaInicio, fechaFin);
        if (existe) {
            throw new RuntimeException(YA_EXISTE_UNA_RESERVA);
        }
    }
}

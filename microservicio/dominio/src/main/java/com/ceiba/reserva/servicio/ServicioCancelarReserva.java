package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.enumerado.EstadoReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCancelarReserva {

    private final RepositorioReserva repositorioReserva;

    public ServicioCancelarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(long id) {
        this.repositorioReserva.actualizarEstado(id, EstadoReserva.RESERVADO.id());
    }
}

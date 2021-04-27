package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarReserva implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Integer>> {

    private final ServicioActualizarReserva servicioActualizarReserva;
    private final FabricaReserva fabricaReserva;

    public ManejadorActualizarReserva(ServicioActualizarReserva servicioActualizarReserva, FabricaReserva fabricaReserva) {
        this.servicioActualizarReserva = servicioActualizarReserva;
        this.fabricaReserva = fabricaReserva;
    }

    @Override
    public ComandoRespuesta<Integer> ejecutar(ComandoReserva comando) {
        Reserva reserva = fabricaReserva.crear(comando);
        return new ComandoRespuesta<>(servicioActualizarReserva.ejecutar(reserva));
    }
}

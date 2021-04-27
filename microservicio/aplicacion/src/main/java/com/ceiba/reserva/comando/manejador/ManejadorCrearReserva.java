package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Long>> {

    private final ServicioCrearReserva servicioCrearReserva;
    private final FabricaReserva fabricaReserva;

    public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva, FabricaReserva fabricaReserva) {
        this.servicioCrearReserva = servicioCrearReserva;
        this.fabricaReserva = fabricaReserva;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoReserva comando) {
        Reserva reserva = this.fabricaReserva.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearReserva.ejecutar(reserva));
    }
}

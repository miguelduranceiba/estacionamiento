package com.ceiba.ocupacion.comando.fabrica;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.ocupacion.comando.ComandoOcupacion;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.tipoVehiculo.puerto.repositorio.RepositorioTipoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Component;

@Component
public class FabricaOcupacion {

    private final RepositorioEspacio repositorioEspacio;
    private final RepositorioConductor repositorioConductor;
    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioReserva repositorioReserva;

    public FabricaOcupacion(RepositorioEspacio repositorioEspacio, RepositorioConductor repositorioConductor, RepositorioVehiculo repositorioVehiculo, RepositorioTipoVehiculo repositorioTipoVehiculo, RepositorioReserva repositorioReserva) {
        this.repositorioEspacio = repositorioEspacio;
        this.repositorioConductor = repositorioConductor;
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioReserva = repositorioReserva;
    }

    public Ocupacion crear(ComandoOcupacion comandoOcupacion) {
        Espacio espacio = repositorioEspacio.consultarPorId(comandoOcupacion.getIdEspacio());
        Conductor conductor = repositorioConductor.consultarPorId(comandoOcupacion.getIdConductor());
        Vehiculo vehiculo = repositorioVehiculo.consultarPorId(comandoOcupacion.getIdVehiculo());
        Reserva reserva = null;
        if (comandoOcupacion.tieneReserva()) {
            reserva = repositorioReserva.consultarPorId(comandoOcupacion.getIdReserva());
        }

        return new Ocupacion(
                comandoOcupacion.getId(),
                espacio,
                conductor,
                vehiculo,
                reserva,
                null,
                comandoOcupacion.getFechaInicio(),
                null
        );
    }

}

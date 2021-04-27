package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.enumerado.EstadoReserva;

import java.time.LocalDateTime;

public class ComandoReservaTestDataBuilder {

    private long id;
    private long idVehiculo;
    private long idConductor;
    private long idEspacio;
    private Integer estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaCreacion;

    public ComandoReservaTestDataBuilder() {
        this.estado = EstadoReserva.RESERVADO.id();
        this.fechaInicio = LocalDateTime.now();
        this.fechaFin = LocalDateTime.now();
        this.fechaCreacion = LocalDateTime.now();
    }


    public ComandoReservaTestDataBuilder conIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdConductor(Long idConductor) {
        this.idConductor = idConductor;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdEspacio(Long idEspacio) {
        this.idEspacio = idEspacio;
        return this;
    }

    public ComandoReserva build() {
        return new ComandoReserva(this.id, this.idVehiculo, this.idConductor, this.idEspacio, this.estado, this.fechaInicio, this.fechaFin, this.fechaCreacion);
    }

}

package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.modelo.enumerado.EstadoReserva;

import java.time.LocalDateTime;

public class ReservaTestDataBuilder {
    private long id;
    private long idVehiculo;
    private long idConductor;
    private long idEspacio;
    private Integer estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaCreacion;

    public ReservaTestDataBuilder() {
        this.estado = EstadoReserva.RESERVADO.id();
        this.fechaInicio = LocalDateTime.now();
        this.fechaFin = LocalDateTime.now();
        this.fechaCreacion = LocalDateTime.now();
    }

    public ReservaTestDataBuilder conFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public ReservaTestDataBuilder conFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public Reserva build() {
        return new Reserva(this.id, this.idVehiculo, this.idConductor, this.idEspacio, this.estado, this.fechaInicio, this.fechaFin, this.fechaCreacion);
    }
}

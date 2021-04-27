package com.ceiba.ocupacion.servicio.testdatabuilder;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.modelo.enumerado.EstadoReserva;
import com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OcupacionTestDataBuilder {

    private long id;
    private Espacio espacio;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private Reserva reserva;
    private BigDecimal total;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private final LocalDateTime now = LocalDateTime.now();

    public OcupacionTestDataBuilder() {
        this.espacio = getEspacio(1L);
        this.conductor = new Conductor(1L, "", "", "", "", "", "", now);
        this.vehiculo = new Vehiculo(1L, "MIGUEL", new TipoVehiculo(com.ceiba.tipoVehiculo.modelo.enumerado.TipoVehiculo.AUTOMOVIL.id(), BigDecimal.ZERO), now);
        this.reserva = new Reserva(1L, 0, 0, 0, EstadoReserva.RESERVADO.id(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
        this.fechaInicio = now;
    }

    private Espacio getEspacio(long id) {
        return new Espacio(id, EstadoEspacio.DISPONIBLE.id(), "", now);
    }

    public OcupacionTestDataBuilder conIdEspacio(long idEspacio) {
        this.espacio = getEspacio(idEspacio);
        return this;
    }

    public Ocupacion build() {
        return new Ocupacion(
                this.id,
                this.espacio,
                this.conductor,
                this.vehiculo,
                this.reserva,
                this.total,
                this.fechaInicio,
                this.fechaFin
        );
    }

}

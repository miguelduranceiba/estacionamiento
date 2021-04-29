package com.ceiba.ocupacion.servicio.testdatabuilder;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.servicio.testdatabuilder.ConductorTestDataBuilder;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OcupacionTestDataBuilder {

    private long id;
    private EspacioTestDataBuilder espacio;
    private ConductorTestDataBuilder conductor;
    private VehiculoTestDataBuilder vehiculo;
    private ReservaTestDataBuilder reserva;
    private BigDecimal total;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private final LocalDateTime now = LocalDateTime.now();

    public OcupacionTestDataBuilder() {
        this.espacio = new EspacioTestDataBuilder();
        this.conductor = new ConductorTestDataBuilder();
        this.vehiculo = new VehiculoTestDataBuilder();
        this.fechaInicio = now;
    }

    public OcupacionTestDataBuilder conIdEspacio(long idEspacio) {
        espacio.conId(id);
        return this;
    }

    public OcupacionTestDataBuilder conEspacio(EspacioTestDataBuilder espacio) {
        this.espacio = espacio;
        return this;
    }

    public OcupacionTestDataBuilder conConductor(ConductorTestDataBuilder conductor) {
        this.conductor = conductor;
        return this;
    }

    public OcupacionTestDataBuilder conVehiculo(VehiculoTestDataBuilder vehiculo) {
        this.vehiculo = vehiculo;
        return this;
    }

    public OcupacionTestDataBuilder conReserva(ReservaTestDataBuilder reserva) {
        this.reserva = reserva;
        return this;
    }

    public OcupacionTestDataBuilder conTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public OcupacionTestDataBuilder conFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public OcupacionTestDataBuilder conFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public Ocupacion build() {
        Espacio espacioBuild = null;
        if (espacio != null) espacioBuild = espacio.build();

        Conductor conductorBuild = null;
        if (conductor != null) conductorBuild = conductor.build();

        Vehiculo vehiculoBuild = null;
        if (vehiculo != null) vehiculoBuild = vehiculo.build();

        Reserva reservaBuild = null;
        if (reserva != null) reservaBuild = reserva.build();

        return new Ocupacion(
                this.id,
                espacioBuild,
                conductorBuild,
                vehiculoBuild,
                reservaBuild,
                this.total,
                this.fechaInicio,
                this.fechaFin
        );
    }

}

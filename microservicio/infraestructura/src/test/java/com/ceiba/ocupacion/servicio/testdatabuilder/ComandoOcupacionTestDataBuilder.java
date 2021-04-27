package com.ceiba.ocupacion.servicio.testdatabuilder;

import com.ceiba.conductor.servicio.testdatabuilder.ComandoConductorTestDataBuilder;
import com.ceiba.ocupacion.comando.ComandoOcupacion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ComandoOcupacionTestDataBuilder {

    private long id;
    private long idEspacio;
    private long idConductor;
    private long idVehiculo;
    private BigDecimal total;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Long idReserva;

    public ComandoOcupacionTestDataBuilder() {
        this.idEspacio = 1L;
        this.idConductor = 1L;
        this.idVehiculo = 1L;
        this.fechaInicio = LocalDateTime.now();
    }

    public ComandoOcupacionTestDataBuilder conIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
        return this;
    }

    public ComandoOcupacionTestDataBuilder conIdConductor(Long idConductor) {
        this.idConductor = idConductor;
        return this;
    }

    public ComandoOcupacionTestDataBuilder conEspacio(Long idEspacio) {
        this.idEspacio = idEspacio;
        return this;
    }

    public ComandoOcupacion build() {
        return new ComandoOcupacion(this.id, this.idEspacio, this.idConductor, this.idVehiculo, this.idReserva, this.total, this.fechaInicio, this.fechaFin);
    }

}

package com.ceiba.vehiculo.testdatabuilder;

import com.ceiba.tipoVehiculo.modelo.enumerado.TipoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VehiculoTestDataBuilder {

    private Long id;
    private String placa;
    private int tipoVehiculo;
    private LocalDateTime fecha;

    public VehiculoTestDataBuilder() {
        this.placa = "MIG002";
        this.tipoVehiculo = TipoVehiculo.AUTOMOVIL.id();
        this.fecha = LocalDateTime.now();
    }

    public VehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Vehiculo build() {
        return new Vehiculo(id, placa, new com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo(tipoVehiculo, new BigDecimal(5000)), fecha);
    }
}

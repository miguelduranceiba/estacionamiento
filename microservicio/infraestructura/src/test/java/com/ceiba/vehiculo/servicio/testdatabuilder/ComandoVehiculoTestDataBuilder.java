package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.tipoVehiculo.modelo.enumerado.TipoVehiculo;
import com.ceiba.vehiculo.comando.ComandoVehiculo;

import java.time.LocalDateTime;

public class ComandoVehiculoTestDataBuilder {

    private Long id;
    private String placa;
    private Integer tipoVehiculo;
    private LocalDateTime fechaCreacion;

    public ComandoVehiculoTestDataBuilder() {
        this.placa = "MIG001";
        this.tipoVehiculo = TipoVehiculo.AUTOMOVIL.id();
        this.fechaCreacion = LocalDateTime.now();
    }

    public ComandoVehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ComandoVehiculoTestDataBuilder conIdTipoVehiculo(int tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ComandoVehiculo build() {
        return new ComandoVehiculo(this.id, this.placa, this.tipoVehiculo, this.fechaCreacion);
    }
}

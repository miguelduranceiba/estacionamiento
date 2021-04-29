package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo;
import com.ceiba.tipoVehiculo.servicio.testdatabuilder.TipoVehiculoTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

import java.time.LocalDateTime;

public class VehiculoTestDataBuilder {

    private Long id;
    private String placa;
    private TipoVehiculoTestDataBuilder tipoVehiculo;
    private LocalDateTime fecha;

    public VehiculoTestDataBuilder() {
        this.placa = "PLA001";
        this.tipoVehiculo = new TipoVehiculoTestDataBuilder();
        this.fecha = LocalDateTime.now();
    }

    public VehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder conTipoVehiculo(TipoVehiculoTestDataBuilder tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public VehiculoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }


    public VehiculoTestDataBuilder conFechaCreacion(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public Vehiculo build() {
        TipoVehiculo tipoVehiculoBuild = null;
        if (tipoVehiculo != null) {
            tipoVehiculoBuild = tipoVehiculo.build();
        }

        return new Vehiculo(id, placa, tipoVehiculoBuild, fecha);
    }

}

package com.ceiba.tipoVehiculo.servicio.testdatabuilder;

import com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo;

import java.math.BigDecimal;

public class TipoVehiculoTestDataBuilder {

    Integer id;
    BigDecimal valor;

    public TipoVehiculoTestDataBuilder() {
        this.id = com.ceiba.tipoVehiculo.modelo.enumerado.TipoVehiculo.AUTOMOVIL.id();
        this.valor = new BigDecimal(5000);
    }

    public TipoVehiculoTestDataBuilder conValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public TipoVehiculoTestDataBuilder conId(int id) {
        this.id = id;
        return this;
    }


    public TipoVehiculo build() {
        return new TipoVehiculo(this.id, valor);
    }
}

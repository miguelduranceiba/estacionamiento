package com.ceiba.tipoVehiculo.modelo.enumerado;

public enum TipoVehiculo {

    AUTOMOVIL(1),
    MOTOCICLETA(2);

    private int identificador;

    TipoVehiculo(int identificador) {
        this.identificador = identificador;
    }

    public int id() {
        return this.identificador;
    }

}

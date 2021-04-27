package com.ceiba.espacio.modelo.enumerado;

public enum EstadoEspacio {

    OCUPADO(0),

    DISPONIBLE(1),

    INACTIVO(2);

    private final int identificador;

    EstadoEspacio(int identificador) {
        this.identificador = identificador;
    }

    public int id() {
        return this.identificador;
    }
}

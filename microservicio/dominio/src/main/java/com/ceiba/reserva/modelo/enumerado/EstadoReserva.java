package com.ceiba.reserva.modelo.enumerado;

public enum EstadoReserva {

    RESERVADO(0),
    CANCELADO(1),
    UTILIZADO(2);

    private int identificador;

    EstadoReserva(int identificador) {
        this.identificador = identificador;
    }

    public int id() {
        return this.identificador;
    }

}

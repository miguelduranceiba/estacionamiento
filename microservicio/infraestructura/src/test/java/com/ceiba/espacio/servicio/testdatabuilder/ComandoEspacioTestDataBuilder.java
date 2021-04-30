package com.ceiba.espacio.servicio.testdatabuilder;

import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;

import java.time.LocalDateTime;

public class ComandoEspacioTestDataBuilder {

    private long id = 1L;
    private String nombre;
    private int estado;
    private LocalDateTime fechaCreacion;

    public ComandoEspacioTestDataBuilder() {
        this.nombre = "Espacio1";
        this.estado = EstadoEspacio.DISPONIBLE.id();
        this.fechaCreacion = LocalDateTime.now();
    }

    public ComandoEspacio build() {
        return new ComandoEspacio(this.id, this.nombre, this.estado, this.fechaCreacion);
    }

}

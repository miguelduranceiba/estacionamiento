package com.ceiba.espacio.servicio.testdatabuilder;

import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;

import java.time.LocalDateTime;

public class EspacioTestDataBuilder {
    private long id;
    private String nombre;
    private Integer estado;
    private LocalDateTime fechaCreacion;

    public EspacioTestDataBuilder() {
        this.nombre = "Espacio-1";
        this.estado = EstadoEspacio.OCUPADO.id();
        this.fechaCreacion = LocalDateTime.now();
    }

    public EspacioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public EspacioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EspacioTestDataBuilder conEstado(Integer estado) {
        this.estado = estado;
        return this;
    }

    public EspacioTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Espacio build() {
        return new Espacio(this.id, this.estado, this.nombre, this.fechaCreacion);
    }
}

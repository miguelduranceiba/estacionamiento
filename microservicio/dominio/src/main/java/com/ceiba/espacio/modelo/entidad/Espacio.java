package com.ceiba.espacio.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Espacio {

    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_FECHA_CREACION = " Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_ESTADO = "Se debe ingresar estado";
    private long id;
    private String nombre;
    private int estado;
    private LocalDateTime fechaCreacion;

    public Espacio(long id, Integer estado, String nombre, LocalDateTime fechaCreacion) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);
        validarObligatorio(estado, SE_DEBE_INGRESAR_ESTADO);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_FECHA_CREACION);

        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

}

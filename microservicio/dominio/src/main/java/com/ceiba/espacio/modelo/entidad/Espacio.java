package com.ceiba.espacio.modelo.entidad;

import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Espacio {

    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_ESTADO = "Se debe ingresar estado";
    private static final String SE_DEBE_INGRESAR_ESTADO_VALIDO = "El estado del espacio no es válido";
    private long id;
    private String nombre;
    private int estado;
    private LocalDateTime fechaCreacion;

    public Espacio(long id, Integer estado, String nombre, LocalDateTime fechaCreacion) {

        validarObligatorio(estado, SE_DEBE_INGRESAR_ESTADO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_FECHA_CREACION);
        validarEnumerado((enumerado) -> enumerado.isId(estado), EstadoEspacio.class, SE_DEBE_INGRESAR_ESTADO_VALIDO);

        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

}

package com.ceiba.espacio.modelo.entidad;

import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Espacio {

    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_ESTADO = "Se debe ingresar estado";
    private static final String SE_DEBE_INGRESAR_ESTADO_VALIDO = "El estado del espacio no es válido";
    private long id;
    private String nombre;
    private int estado;
    private LocalDateTime fechaCreacion;

    public Espacio(long id, Integer estado, String nombre, LocalDateTime fechaCreacion) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);
        validarObligatorio(estado, SE_DEBE_INGRESAR_ESTADO);
        validarEnumerado((enumerado) -> enumerado.isId(estado), EstadoEspacio.class, SE_DEBE_INGRESAR_ESTADO_VALIDO);

        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

}

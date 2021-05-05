package com.ceiba.conductor.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Conductor {

    private static final String SE_DEBE_INGRESAR_TIPO_IDENTIFICACION = "Se debe ingresar tipo de identificación";
    private static final String SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION = "Se debe ingresar número de identificación";
    private static final String SE_DEBE_INGRESAR_PRIMER_NOMBRE = "Se debe ingresar el primer nombre";
    private static final String SE_DEBE_INGRESAR_PRIMER_APELLIDO = "Se debe ingresar el primer apellido";

    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDateTime fechaCreacion;

    public Conductor(Long id, String tipoIdentificacion, String numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, LocalDateTime fechaCreacion) {
        validarObligatorio(tipoIdentificacion, SE_DEBE_INGRESAR_TIPO_IDENTIFICACION);
        validarObligatorio(numeroIdentificacion, SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION);
        validarObligatorio(primerNombre, SE_DEBE_INGRESAR_PRIMER_NOMBRE);
        validarObligatorio(primerApellido, SE_DEBE_INGRESAR_PRIMER_APELLIDO);

        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaCreacion = fechaCreacion;
    }
}

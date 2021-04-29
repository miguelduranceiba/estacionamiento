package com.ceiba.conductor.servicio.testdatabuilder;

import com.ceiba.conductor.modelo.entidad.Conductor;

import java.time.LocalDateTime;

public class ConductorTestDataBuilder {

    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDateTime fecha;

    public ConductorTestDataBuilder() {
        this.tipoIdentificacion = "CC";
        this.numeroIdentificacion = "1098123456";
        this.primerNombre = "PEDRO";
        this.primerApellido = "CACERES";
        this.fecha = LocalDateTime.now();
    }

    public ConductorTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ConductorTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public ConductorTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ConductorTestDataBuilder conPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
        return this;
    }

    public ConductorTestDataBuilder conSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
        return this;
    }

    public ConductorTestDataBuilder conPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public ConductorTestDataBuilder conSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public ConductorTestDataBuilder conFechaCreacion(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public Conductor build() {
        return new Conductor(this.id, this.tipoIdentificacion, this.numeroIdentificacion, this.primerNombre, this.segundoNombre, this.primerApellido, this.segundoApellido, fecha);
    }

}

package com.ceiba.conductor.servicio.testdatabuilder;

import com.ceiba.conductor.comando.ComandoConductor;
import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;

public class ComandoConductorTestDataBuilder {

    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDateTime fecha;

    public ComandoConductorTestDataBuilder() {
        this.tipoIdentificacion = "CC";
        this.numeroIdentificacion = "1098123456";
        this.primerNombre = "PEDRO";
        this.primerApellido = "CACERES";
        this.fecha = LocalDateTime.now();
    }

    public ComandoConductorTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public ComandoConductorTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ComandoConductorTestDataBuilder conPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
        return this;
    }

    public ComandoConductorTestDataBuilder conSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
        return this;
    }

    public ComandoConductorTestDataBuilder conPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public ComandoConductorTestDataBuilder conSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public ComandoConductor build() {
        return new ComandoConductor(this.id, this.tipoIdentificacion, this.numeroIdentificacion, this.primerNombre, this.segundoNombre, this.primerApellido, this.segundoApellido, fecha);
    }

}

package com.ceiba.reserva.modelo.entidad;

import com.ceiba.reserva.modelo.enumerado.EstadoReserva;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_FECHA_INICIO = "Se debe ingresar fecha inicio";
    private static final String SE_DEBE_INGRESAR_FECHA_FIN = "Se debe ingresar fecha fin";
    private static final String SE_DEBE_INGRESAR_ESTADO = "Se debe ingresar el estado";
    private long id;
    private long idVehiculo;
    private long idConductor;
    private long idEspacio;
    private int estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaCreacion;

    public Reserva(long id, long idVehiculo, long idConductor, long idEspacio, Integer estado, LocalDateTime fechaInicio, LocalDateTime fechaFin, LocalDateTime fechaCreacion) {
        validarObligatorio(estado, SE_DEBE_INGRESAR_ESTADO);
        validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_FECHA_INICIO);
        validarObligatorio(fechaFin, SE_DEBE_INGRESAR_FECHA_FIN);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.idVehiculo = idVehiculo;
        this.idConductor = idConductor;
        this.idEspacio = idEspacio;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaCreacion = fechaCreacion;
    }

    public void reservar() {
        this.estado = EstadoReserva.RESERVADO.id();
    }

}

package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDateTime;

public interface RepositorioReserva {

    /**
     * Permite crear una reserva
     *
     * @param reserva
     * @return
     */
    Long crear(Reserva reserva);

    /**
     * Permite actualizar la reserva
     *
     * @param reserva
     * @return
     */
    int actualizar(Reserva reserva);

    /**
     * Permite eliminar la reserva
     *
     * @param id
     */
    void actualizarEstado(long id, int estado);

    /**
     * Permite validar si existe una reserva en el rango de fecha
     *
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    boolean existe(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    /**
     * Permite validar que no exista una reserva en el rango de tiempo diferente al ya reservado con anterioridad
     *
     * @param id
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    boolean existenciaId(long id, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    /**
     * Permite consultar por id la reserva
     *
     * @param idReserva
     * @return
     */
    Reserva consultarPorId(long idReserva);
}

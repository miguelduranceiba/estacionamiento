package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;

import java.util.List;

public interface DaoReserva {

    /**
     * Permite listar las reservas por vehiculo
     *
     * @param idVehiculo
     * @return
     */
    List<DtoReserva> listarReservaPorVehiculo(long idVehiculo);

}

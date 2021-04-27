package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarReservaPorVehiculo {

    private final DaoReserva daoReserva;

    public ManejadorListarReservaPorVehiculo(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public List<DtoReserva> ejecutar(long idVehiculo) {
        return this.daoReserva.listarReservaPorVehiculo(idVehiculo);
    }
}

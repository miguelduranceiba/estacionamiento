package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorListarReservaPorVehiculo;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Api(tags = {"Controlador consulta reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListarReservaPorVehiculo manejadorListarReservaPorVehiculo;

    public ConsultaControladorReserva(ManejadorListarReservaPorVehiculo manejadorListarReservaPorVehiculo) {
        this.manejadorListarReservaPorVehiculo = manejadorListarReservaPorVehiculo;
    }

    @GetMapping( "vehiculo/{idVehiculo}")
    @ApiOperation("Consultar Reservas por Vehículo")
    public List<DtoReserva> listarPorVehiculo(@PathVariable long idVehiculo) {
        return this.manejadorListarReservaPorVehiculo.ejecutar(idVehiculo);
    }
}

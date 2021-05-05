package com.ceiba.vehiculo.controlador;

import com.ceiba.vehiculo.consulta.ManejadorListarVehiculo;
import com.ceiba.vehiculo.consulta.ManejadorListarVehiculoPorPlaca;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@Api(tags = {"Controlador consulta vehiculo"})
public class ConsultaControladorVehiculo {

    private final ManejadorListarVehiculo manejadorListarVehiculo;
    private final ManejadorListarVehiculoPorPlaca manejadorListarVehiculoPorPlaca;

    public ConsultaControladorVehiculo(ManejadorListarVehiculo manejadorListarVehiculo, ManejadorListarVehiculoPorPlaca manejadorListarVehiculoPorPlaca) {
        this.manejadorListarVehiculo = manejadorListarVehiculo;
        this.manejadorListarVehiculoPorPlaca = manejadorListarVehiculoPorPlaca;
    }

    @GetMapping
    @ApiOperation("Listar vehiculos")
    public List<DtoVehiculo> listar() {
        return this.manejadorListarVehiculo.ejecutar();
    }

    @GetMapping("placa/{placa}")
    @ApiOperation("Consultar vehículo por placa")
    public DtoVehiculo consultarPorPlaca(@PathVariable String placa) {
        return this.manejadorListarVehiculoPorPlaca.ejecutar(placa);
    }
}

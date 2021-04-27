package com.ceiba.vehiculo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.comando.manejador.ManejadorCrearVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
@Api(tags = {"Controlador comando vehiculo"})
public class ComandoControladorVehiculo {

    private final ManejadorCrearVehiculo manejadorCrearVehiculo;

    public ComandoControladorVehiculo(ManejadorCrearVehiculo manejadorCrearVehiculo) {
        this.manejadorCrearVehiculo = manejadorCrearVehiculo;
    }

    @PostMapping
    @ApiOperation("Crear Vehiculo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVehiculo comandoVehiculo) {
        return manejadorCrearVehiculo.ejecutar(comandoVehiculo);
    }

}

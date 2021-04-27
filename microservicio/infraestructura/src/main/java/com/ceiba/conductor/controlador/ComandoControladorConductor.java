package com.ceiba.conductor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.conductor.comando.ComandoConductor;
import com.ceiba.conductor.comando.manejador.ManejadorActualizarConductor;
import com.ceiba.conductor.comando.manejador.ManejadorCrearConductor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conductores")
@Api(tags = {"Controlador comando conductor"})
public class ComandoControladorConductor {

    private final ManejadorCrearConductor manejadorCrearConductor;
    private final ManejadorActualizarConductor manejadorActualizarConductor;

    public ComandoControladorConductor(ManejadorCrearConductor manejadorCrearConductor, ManejadorActualizarConductor manejadorActualizarConductor) {
        this.manejadorCrearConductor = manejadorCrearConductor;
        this.manejadorActualizarConductor = manejadorActualizarConductor;
    }

    @PostMapping
    @ApiOperation("Crear conductor")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoConductor comandoConductor) {
        return manejadorCrearConductor.ejecutar(comandoConductor);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar conductor")
    public ComandoRespuesta<Integer> actualizar(@RequestBody ComandoConductor comandoConductor, @PathVariable Long id) {
        comandoConductor.setId(id);
        return manejadorActualizarConductor.ejecutar(comandoConductor);
    }
}

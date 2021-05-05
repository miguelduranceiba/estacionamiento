package com.ceiba.espacio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorActualizarEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorCrearEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorEliminarEspacio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/espacio")
@Api(tags = {"Controlador comando espacio"})
public class ComandoControladorEspacio {

    private final ManejadorCrearEspacio manejadorCrearEspacio;
    private final ManejadorEliminarEspacio manejadorEliminarEspacio;
    private final ManejadorActualizarEspacio manejadorActualizarEspacio;

    public ComandoControladorEspacio(ManejadorCrearEspacio manejadorCrearEspacio, ManejadorEliminarEspacio manejadorEliminarEspacio, ManejadorActualizarEspacio manejadorActualizarEspacio) {
        this.manejadorCrearEspacio = manejadorCrearEspacio;
        this.manejadorEliminarEspacio = manejadorEliminarEspacio;
        this.manejadorActualizarEspacio = manejadorActualizarEspacio;
    }

    @PostMapping
    @ApiOperation("Crear Espacio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEspacio comandoEspacio) {
        return manejadorCrearEspacio.ejecutar(comandoEspacio);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Espacio")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarEspacio.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Espacio")
    public ComandoRespuesta<Integer> actualizar(@RequestBody ComandoEspacio comandoEspacio, @PathVariable Long id) {
        comandoEspacio.setId(id);
        return manejadorActualizarEspacio.ejecutar(comandoEspacio);
    }
}

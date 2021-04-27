package com.ceiba.espacio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorCrearEspacio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/espacio")
@Api(tags = {"Controlador comando espacio"})
public class ComandoControladorEspacio {

    private final ManejadorCrearEspacio manejadorCrearEspacio;

    public ComandoControladorEspacio(ManejadorCrearEspacio manejadorCrearEspacio) {
        this.manejadorCrearEspacio = manejadorCrearEspacio;
    }

    @PostMapping
    @ApiOperation("Crear espacio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEspacio comandoEspacio) {
        return manejadorCrearEspacio.ejecutar(comandoEspacio);
    }
}

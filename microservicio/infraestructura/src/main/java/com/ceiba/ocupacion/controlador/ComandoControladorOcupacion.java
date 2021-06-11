package com.ceiba.ocupacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.ocupacion.comando.ComandoOcupacion;
import com.ceiba.ocupacion.comando.manejador.ManejadorCrearOcupacion;
import com.ceiba.ocupacion.comando.manejador.ManejadorPagarOcupacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ocupacion")
@Api(tags = {"Controlador comando ocupacion"})
public class ComandoControladorOcupacion {

    private final ManejadorCrearOcupacion manejadorCrearOcupacion;
    private final ManejadorPagarOcupacion manejadorPagarOcupacion;

    public ComandoControladorOcupacion(ManejadorCrearOcupacion manejadorCrearOcupacion, ManejadorPagarOcupacion manejadorPagarOcupacion) {
        this.manejadorCrearOcupacion = manejadorCrearOcupacion;
        this.manejadorPagarOcupacion = manejadorPagarOcupacion;
    }

    @PostMapping
    @ApiOperation("Crear ocupacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoOcupacion comandoOcupacion) {
        return manejadorCrearOcupacion.ejecutar(comandoOcupacion);
    }

    @PostMapping(path = "/pagar/{idOcupacion}")
    @ApiOperation("Pagar por ocupación")
    public void pagar(@PathVariable long idOcupacion) {
        manejadorPagarOcupacion.ejecutar(idOcupacion);
    }

}

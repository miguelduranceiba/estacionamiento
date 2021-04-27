package com.ceiba.ocupacion.controlador;

import com.ceiba.ocupacion.consultar.ManejadorListarOcupacion;
import com.ceiba.ocupacion.modelo.dto.DtoOcupacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ocupacion")
@Api(tags = {"Controlador consulta ocupacion"})
public class ConsultaControladorOcupacion {

    private final ManejadorListarOcupacion manejadorListarOcupacion;

    public ConsultaControladorOcupacion(ManejadorListarOcupacion manejadorListarOcupacion) {
        this.manejadorListarOcupacion = manejadorListarOcupacion;
    }

    @GetMapping
    @ApiOperation("Listar ocupacion")
    public List<DtoOcupacion> listar() {
        return this.manejadorListarOcupacion.ejecutar();
    }
}

package com.ceiba.conductor.controlador;

import com.ceiba.conductor.consulta.ManejadorListarConductor;
import com.ceiba.conductor.modelo.dto.DtoConductor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conductores")
@Api(tags = {"Controlador consulta conductor"})
public class ConsultaControladorConductor {

    private final ManejadorListarConductor manejadorListarConductor;

    public ConsultaControladorConductor(ManejadorListarConductor manejadorListarConductor) {
        this.manejadorListarConductor = manejadorListarConductor;
    }

    @GetMapping
    @ApiOperation("Listar conductores")
    public List<DtoConductor> listar() {
        return this.manejadorListarConductor.ejecutar();
    }
}

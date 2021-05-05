package com.ceiba.conductor.controlador;

import com.ceiba.conductor.consulta.ManejadorConsultarConductorPorIdentificacion;
import com.ceiba.conductor.consulta.ManejadorListarConductor;
import com.ceiba.conductor.modelo.dto.DtoConductor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conductores")
@Api(tags = {"Controlador consulta conductor"})
public class ConsultaControladorConductor {

    private final ManejadorListarConductor manejadorListarConductor;
    private final ManejadorConsultarConductorPorIdentificacion manejadorConsultarConductorPorIdentificacion;

    public ConsultaControladorConductor(ManejadorListarConductor manejadorListarConductor, ManejadorConsultarConductorPorIdentificacion manejadorConsultarConductorPorIdentificacion) {
        this.manejadorListarConductor = manejadorListarConductor;
        this.manejadorConsultarConductorPorIdentificacion = manejadorConsultarConductorPorIdentificacion;
    }

    @GetMapping
    @ApiOperation("Listar conductores")
    public List<DtoConductor> listar() {
        return this.manejadorListarConductor.ejecutar();
    }

    @GetMapping("identificacion/{identificacion}")
    @ApiOperation("Consultar Por Identificación")
    public DtoConductor consultarPorIdentificacion(@PathVariable String identificacion) {
        return this.manejadorConsultarConductorPorIdentificacion.ejecutar(identificacion);
    }
}

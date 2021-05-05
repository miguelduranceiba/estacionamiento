package com.ceiba.espacio.controlador;

import com.ceiba.espacio.consulta.ManejadorConsultarEspacioPorId;
import com.ceiba.espacio.consulta.ManejadorListarEspacio;
import com.ceiba.espacio.consulta.ManejadorListarEspacioDisponible;
import com.ceiba.espacio.modelo.dto.DtoEspacio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacio")
@Api(tags = {"Controlador consulta espacio"})
public class ConsultaControladorEspacio {

    private final ManejadorListarEspacioDisponible manejadorListarEspacioDisponible;
    private final ManejadorListarEspacio manejadorListarEspacio;
    private final ManejadorConsultarEspacioPorId manejadorConsultarEspacioPorId;

    public ConsultaControladorEspacio(ManejadorListarEspacioDisponible manejadorListarEspacioDisponible, ManejadorListarEspacio manejadorListarEspacio, ManejadorConsultarEspacioPorId manejadorConsultarEspacioPorId) {
        this.manejadorListarEspacioDisponible = manejadorListarEspacioDisponible;
        this.manejadorListarEspacio = manejadorListarEspacio;
        this.manejadorConsultarEspacioPorId = manejadorConsultarEspacioPorId;
    }

    @GetMapping
    @ApiOperation("Listar Espacio")
    public List<DtoEspacio> listar() {
        return this.manejadorListarEspacio.ejecutar();
    }

    @GetMapping(value = "{id}")
    @ApiOperation("Consultar Espacio Por Id")
    public DtoEspacio consultarPorId(@PathVariable long id) {
        return this.manejadorConsultarEspacioPorId.ejecutar(id);
    }

    @GetMapping(path = "/disponible")
    @ApiOperation("Listar Espacio Disponible")
    public List<DtoEspacio> listarEspacioDisponible() {
        return this.manejadorListarEspacioDisponible.ejecutar();
    }

}

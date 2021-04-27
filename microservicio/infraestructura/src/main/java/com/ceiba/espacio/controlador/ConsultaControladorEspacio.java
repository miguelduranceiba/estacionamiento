package com.ceiba.espacio.controlador;

import com.ceiba.espacio.consulta.ManejadorListarEspacioDisponible;
import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacio")
@Api(tags = {"Controlador consulta espacio"})
public class ConsultaControladorEspacio {

    private final ManejadorListarEspacioDisponible manejadorListarEspacioDisponible;

    public ConsultaControladorEspacio(ManejadorListarEspacioDisponible manejadorListarEspacioDisponible) {
        this.manejadorListarEspacioDisponible = manejadorListarEspacioDisponible;
    }

    @GetMapping(path = "/disponible")
    @ApiOperation("Listar Espacio Disponible")
    public List<DtoEspacio> listarEspacioDisponible() {
        return this.manejadorListarEspacioDisponible.ejecutar();
    }

}

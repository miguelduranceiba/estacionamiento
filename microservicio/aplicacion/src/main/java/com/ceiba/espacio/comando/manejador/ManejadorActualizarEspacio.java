package com.ceiba.espacio.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.comando.fabrica.FabricaEspacio;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.servicio.ServicioActualizarEspacio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEspacio implements ManejadorComandoRespuesta<ComandoEspacio, ComandoRespuesta<Integer>> {

    private final FabricaEspacio fabricaEspacio;
    private final ServicioActualizarEspacio servicioActualizarEspacio;

    public ManejadorActualizarEspacio(FabricaEspacio fabricaEspacio, ServicioActualizarEspacio servicioActualizarEspacio) {
        this.fabricaEspacio = fabricaEspacio;
        this.servicioActualizarEspacio = servicioActualizarEspacio;
    }

    public ComandoRespuesta<Integer> ejecutar(ComandoEspacio comandoEspacio) {
        Espacio espacio = this.fabricaEspacio.crear(comandoEspacio);
        return new ComandoRespuesta<>(this.servicioActualizarEspacio.ejecutar(espacio));
    }

}

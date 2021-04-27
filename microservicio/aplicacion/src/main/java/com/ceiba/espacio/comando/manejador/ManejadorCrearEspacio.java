package com.ceiba.espacio.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.comando.fabrica.FabricaEspacio;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.servicio.ServicioCrearEspacio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEspacio implements ManejadorComandoRespuesta<ComandoEspacio, ComandoRespuesta<Long>> {

    private final FabricaEspacio fabricaEspacio;
    private final ServicioCrearEspacio servicioCrearEspacio;

    public ManejadorCrearEspacio(FabricaEspacio fabricaEspacio, ServicioCrearEspacio servicioCrearEspacio) {
        this.fabricaEspacio = fabricaEspacio;
        this.servicioCrearEspacio = servicioCrearEspacio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoEspacio comando) {
        Espacio espacio = fabricaEspacio.crear(comando);
        return new ComandoRespuesta<>(servicioCrearEspacio.ejecutar(espacio));
    }


}

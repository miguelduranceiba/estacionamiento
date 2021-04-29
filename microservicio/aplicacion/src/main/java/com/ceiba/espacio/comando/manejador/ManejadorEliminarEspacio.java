package com.ceiba.espacio.comando.manejador;

import com.ceiba.espacio.servicio.ServicioEliminarEspacio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEspacio implements ManejadorComando<Long> {

    private final ServicioEliminarEspacio servicioEliminarEspacio;

    public ManejadorEliminarEspacio(ServicioEliminarEspacio servicioEliminarEspacio) {
        this.servicioEliminarEspacio = servicioEliminarEspacio;
    }

    @Override
    public void ejecutar(Long id) {
        this.servicioEliminarEspacio.ejecutar(id);
    }
}

package com.ceiba.conductor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.conductor.comando.ComandoConductor;
import com.ceiba.conductor.comando.fabrica.FabricaConductor;
import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.servicio.ServicioCrearConductor;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearConductor implements ManejadorComandoRespuesta<ComandoConductor, ComandoRespuesta<Long>> {

    private final ServicioCrearConductor servicioCrearConductor;
    private final FabricaConductor fabricaConductor;

    public ManejadorCrearConductor(ServicioCrearConductor servicioCrearConductor, FabricaConductor fabricaConductor) {
        this.servicioCrearConductor = servicioCrearConductor;
        this.fabricaConductor = fabricaConductor;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoConductor comando) {
        Conductor conductor = fabricaConductor.crear(comando);
        return new ComandoRespuesta<>(servicioCrearConductor.ejecutar(conductor));
    }
}

package com.ceiba.conductor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.conductor.comando.ComandoConductor;
import com.ceiba.conductor.comando.fabrica.FabricaConductor;
import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.servicio.ServicioActualizarConductor;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarConductor implements ManejadorComandoRespuesta<ComandoConductor, ComandoRespuesta<Integer>> {

    private final FabricaConductor fabricaConductor;
    private final ServicioActualizarConductor servicioActualizarConductor;

    public ManejadorActualizarConductor(FabricaConductor fabricaConductor, ServicioActualizarConductor servicioActualizarConductor) {
        this.fabricaConductor = fabricaConductor;
        this.servicioActualizarConductor = servicioActualizarConductor;
    }

    @Override
    public ComandoRespuesta<Integer> ejecutar(ComandoConductor comando) {
        Conductor conductor = fabricaConductor.crear(comando);
        return new ComandoRespuesta<>(servicioActualizarConductor.ejecutar(conductor));
    }
}

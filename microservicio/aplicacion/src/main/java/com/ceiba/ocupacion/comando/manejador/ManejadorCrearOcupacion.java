package com.ceiba.ocupacion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.ocupacion.comando.ComandoOcupacion;
import com.ceiba.ocupacion.comando.fabrica.FabricaOcupacion;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.ocupacion.servicio.ServicioCrearOcupacion;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ManejadorCrearOcupacion implements ManejadorComandoRespuesta<ComandoOcupacion, ComandoRespuesta<Long>> {

    private final FabricaOcupacion fabricaOcupacion;
    private final ServicioCrearOcupacion servicioCrearOcupacion;

    public ManejadorCrearOcupacion(FabricaOcupacion fabricaOcupacion, ServicioCrearOcupacion servicioCrearOcupacion) {
        this.fabricaOcupacion = fabricaOcupacion;
        this.servicioCrearOcupacion = servicioCrearOcupacion;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoOcupacion comandoOcupacion) {
        comandoOcupacion.setFechaInicio(LocalDateTime.now());
        Ocupacion ocupacion = this.fabricaOcupacion.crear(comandoOcupacion);
        return new ComandoRespuesta<>(this.servicioCrearOcupacion.ejecutar(ocupacion));
    }
}

package com.ceiba.ocupacion.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.ocupacion.servicio.ServicioPagarOcupacion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPagarOcupacion implements ManejadorComando<Long> {

    private final ServicioPagarOcupacion servicioPagarOcupacion;

    public ManejadorPagarOcupacion(ServicioPagarOcupacion servicioPagarOcupacion) {
        this.servicioPagarOcupacion = servicioPagarOcupacion;
    }

    @Override
    public void ejecutar(Long idOcupacion) {
        servicioPagarOcupacion.ejecutar(idOcupacion);
    }
}

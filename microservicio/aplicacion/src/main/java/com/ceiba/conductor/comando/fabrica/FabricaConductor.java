package com.ceiba.conductor.comando.fabrica;

import com.ceiba.conductor.comando.ComandoConductor;
import com.ceiba.conductor.modelo.entidad.Conductor;
import org.springframework.stereotype.Component;

@Component
public class FabricaConductor {

    public Conductor crear(ComandoConductor comandoConductor) {
        return new Conductor(
                comandoConductor.getId(),
                comandoConductor.getTipoIdentificacion(),
                comandoConductor.getNumeroIdentificacion(),
                comandoConductor.getPrimerNombre(),
                comandoConductor.getSegundoNombre(),
                comandoConductor.getPrimerApellido(),
                comandoConductor.getSegundoApellido(),
                comandoConductor.getFecha()
        );
    }
}

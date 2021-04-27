package com.ceiba.espacio.comando.fabrica;

import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.modelo.entidad.Espacio;
import org.springframework.stereotype.Component;

@Component
public class FabricaEspacio {

    public Espacio crear(ComandoEspacio comandoEspacio) {
        return new Espacio(
                comandoEspacio.getId(),
                comandoEspacio.getEstado(),
                comandoEspacio.getNombre(),
                comandoEspacio.getFechaCreacion()
        );
    }
}

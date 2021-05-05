package com.ceiba.conductor.consulta;

import com.ceiba.conductor.modelo.dto.DtoConductor;
import com.ceiba.conductor.puerto.dao.DaoConductor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarConductorPorIdentificacion {

    private final DaoConductor daoConductor;

    public ManejadorConsultarConductorPorIdentificacion(DaoConductor daoConductor) {
        this.daoConductor = daoConductor;
    }

    public DtoConductor ejecutar(String identificacion) {
        return this.daoConductor.consultarPorIdentificacion(identificacion);
    }
}

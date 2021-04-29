package com.ceiba.conductor.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.conductor.servicio.testdatabuilder.ConductorTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarConductorTest {

    @Test
    public void excepcionPorDuplicidad() {

        Long id = 1L;
        String tipo = "CC";
        String numero = "123456789";

        Conductor conductor = new ConductorTestDataBuilder().conId(id).conTipoIdentificacion(tipo).conNumeroIdentificacion(numero).build();

        RepositorioConductor repositorioConductor = Mockito.mock(RepositorioConductor.class);

        Mockito.when(repositorioConductor.existeExcluyendoId(id, tipo, numero)).thenReturn(true);

        ServicioActualizarConductor servicioActualizarConductor = new ServicioActualizarConductor(repositorioConductor);

        BasePrueba.assertThrows(() -> servicioActualizarConductor.ejecutar(conductor), ExcepcionDuplicidad.class, "El tipo y número de identificación estan asociados a otro conductor");
    }

    @Test
    public void validarActualizarExitoso() {

        Conductor conductor = new ConductorTestDataBuilder().build();

        RepositorioConductor repositorioConductor = Mockito.mock(RepositorioConductor.class);

        ServicioActualizarConductor servicioActualizarConductor = new ServicioActualizarConductor(repositorioConductor);

        BasePrueba.assertValid(() -> servicioActualizarConductor.ejecutar(conductor));
    }
}

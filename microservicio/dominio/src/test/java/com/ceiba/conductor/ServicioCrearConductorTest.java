package com.ceiba.conductor;

import com.ceiba.BasePrueba;
import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.conductor.servicio.ServicioCrearConductor;
import com.ceiba.conductor.testdatabuilder.ConductorTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearConductorTest {

    @Test
    public void validarCrearConductorSiYaExiste() {
        Conductor conductor = new ConductorTestDataBuilder().build();
        RepositorioConductor repositorioConductor = Mockito.mock(RepositorioConductor.class);
        Mockito.when(repositorioConductor.existe(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        ServicioCrearConductor servicioCrearConductor = new ServicioCrearConductor(repositorioConductor);

        BasePrueba.assertThrows(() -> servicioCrearConductor.ejecutar(conductor), ExcepcionDuplicidad.class, ServicioCrearConductor.EL_CONDUCTOR_YA_EXISTE);
    }

    @Test
    public void validarCrearConductorSiNoExiste() {
        Conductor conductor = new ConductorTestDataBuilder().build();
        RepositorioConductor repositorioConductor = Mockito.mock(RepositorioConductor.class);
        ServicioCrearConductor servicioCrearConductor = new ServicioCrearConductor(repositorioConductor);

        try {
            servicioCrearConductor.ejecutar(conductor);
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail();
        }

    }
}

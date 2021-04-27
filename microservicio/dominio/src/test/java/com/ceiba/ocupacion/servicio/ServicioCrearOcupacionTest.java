package com.ceiba.ocupacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.testdatabuilder.ConductorTestDataBuilder;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;
import com.ceiba.ocupacion.servicio.testdatabuilder.OcupacionTestDataBuilder;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServicioCrearOcupacionTest {

    @Test
    public void validarExistenciaOcupacionEspacio() {
        Long idEspacio = 1L;

        Ocupacion ocupacion = new OcupacionTestDataBuilder().conIdEspacio(idEspacio).build();

        RepositorioOcupacion repositorioOcupacion = Mockito.mock(RepositorioOcupacion.class);
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        Mockito.when(repositorioEspacio.estadoEspacio(idEspacio, EstadoEspacio.OCUPADO.id())).thenReturn(true);
        ServicioCrearOcupacion servicioCrearOcupacion = new ServicioCrearOcupacion(repositorioOcupacion, repositorioEspacio);

        BasePrueba.assertThrows(() -> servicioCrearOcupacion.ejecutar(ocupacion), RuntimeException.class, ServicioCrearOcupacion.EL_ESPACIO_ESTA_OCUPADO);
    }

}

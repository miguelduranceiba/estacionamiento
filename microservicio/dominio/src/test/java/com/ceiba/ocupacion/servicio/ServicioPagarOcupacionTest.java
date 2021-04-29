package com.ceiba.ocupacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.servicio.testdatabuilder.ConductorTestDataBuilder;
import com.ceiba.diaFestivo.modelo.entidad.Festivo;
import com.ceiba.diaFestivo.puerto.repositorio.RepositorioFestivo;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;
import com.ceiba.ocupacion.servicio.testdatabuilder.OcupacionTestDataBuilder;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioPagarOcupacionTest {

    @Test
    public void validarPagarOcupacionFestivo() {
        Long id = 1L;

        RepositorioOcupacion repositorioOcupacion = Mockito.mock(RepositorioOcupacion.class);
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        RepositorioFestivo repositorioFestivo = Mockito.mock(RepositorioFestivo.class);

        List<Festivo> listaFestivo = new ArrayList<>();
        Mockito.when(repositorioFestivo.listar()).thenReturn(listaFestivo);
        Mockito.when(repositorioOcupacion.consultarPorId(id)).thenReturn(new OcupacionTestDataBuilder().build());

        ServicioPagarOcupacion servicioPagarOcupacion = new ServicioPagarOcupacion(repositorioOcupacion, repositorioEspacio, repositorioFestivo);

        BasePrueba.assertValid(() -> servicioPagarOcupacion.ejecutar(id));
    }

}

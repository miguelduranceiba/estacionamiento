package com.ceiba.ocupacion.servicio;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.testdatabuilder.ConductorTestDataBuilder;
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
import com.ceiba.vehiculo.testdatabuilder.VehiculoTestDataBuilder;
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

        long id = 1L;
        Espacio espacio = new Espacio(1L, 0, "", LocalDateTime.now());
        Conductor conductor = new ConductorTestDataBuilder().build();
        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
        Reserva reserva = new ReservaTestDataBuilder().build();
        BigDecimal total = null;
        LocalDateTime fechaFestivo = LocalDateTime.now().minusHours(3);
        LocalDateTime fechaFin = null;

        Ocupacion ocupacion = new Ocupacion(id, espacio, conductor, vehiculo, reserva, total, fechaFestivo, fechaFin);

        List<Festivo> listaFestivo = new ArrayList<>();
        listaFestivo.add(new Festivo(1L, fechaFestivo));

        ocupacion.finalizar(listaFestivo);

        Assert.assertEquals(ocupacion.getTotal(), new BigDecimal(30000));
    }

}

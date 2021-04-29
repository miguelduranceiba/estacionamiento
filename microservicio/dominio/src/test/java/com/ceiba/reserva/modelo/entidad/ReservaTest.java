package com.ceiba.reserva.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;

public class ReservaTest {

    @Test
    public void validarInicializacionReserva() {
        BasePrueba.assertValid(() -> new ReservaTestDataBuilder().build());
    }

    @Test
    public void excepcionVehiculoObligatorio() {
        BasePrueba.assertThrows(() -> new ReservaTestDataBuilder().conIdVehiculo(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar el vehículo");
    }

    @Test
    public void excepcionConductorObligatorio() {
        BasePrueba.assertThrows(() -> new ReservaTestDataBuilder().conIdConductor(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar el conductor");
    }

    @Test
    public void excepcionEspacioObligatorio() {
        BasePrueba.assertThrows(() -> new ReservaTestDataBuilder().conIdEspacio(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar el espacio");
    }

    @Test
    public void excepcionFechaInicioObligatorio() {
        BasePrueba.assertThrows(() -> new ReservaTestDataBuilder().conFechaInicio(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar fecha inicio");
    }

    @Test
    public void excepcionFechaFinObligatorio() {
        BasePrueba.assertThrows(() -> new ReservaTestDataBuilder().conFechaFin(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar fecha fin");
    }

    @Test
    public void excepcionFechaCreacionObligatorio() {
        BasePrueba.assertThrows(() -> new ReservaTestDataBuilder().conFechaCreacion(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
    }
}

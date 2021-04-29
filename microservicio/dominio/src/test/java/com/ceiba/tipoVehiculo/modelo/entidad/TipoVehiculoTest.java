package com.ceiba.tipoVehiculo.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.tipoVehiculo.servicio.testdatabuilder.TipoVehiculoTestDataBuilder;
import org.junit.Test;

public class TipoVehiculoTest {

    @Test
    public void validarInicializacionTipoVehiculo() {
        BasePrueba.assertValid(() -> new TipoVehiculoTestDataBuilder().build());
    }

    @Test
    public void excepcionValorObligatorio() {
        BasePrueba.assertThrows(() -> new TipoVehiculoTestDataBuilder().conValor(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar el valor");
    }
}

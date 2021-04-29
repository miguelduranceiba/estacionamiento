package com.ceiba.diaFestivo.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.diaFestivo.servicio.testdatabuider.FestivoTestaDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Test;

public class FestivoTest {

    @Test
    public void validarInicializacionFestivo() {
        BasePrueba.assertValid(() -> new FestivoTestaDataBuilder().build());
    }

    @Test
    public void excepcionDiaObligatorio() {
        BasePrueba.assertThrows(() -> new FestivoTestaDataBuilder().conDia(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar el día festivo");
    }
}

package com.ceiba.espacio.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;
import org.junit.Test;

public class EspacioTest {

    @Test
    public void construccionPorDefectoValida() {
        BasePrueba.assertValid(() ->
                new EspacioTestDataBuilder().build()
        );
    }

    @Test
    public void validarEstadoObligatorio() {
        BasePrueba.assertThrows(() ->
                        new EspacioTestDataBuilder().conEstado(null).build(),
                ExcepcionValorObligatorio.class,
                "Se debe ingresar estado"
        );
    }

    @Test
    public void estadoInvalido() {
        BasePrueba.assertThrows(() ->
                        new EspacioTestDataBuilder().conEstado(-1).build(),
                ExcepcionValorInvalido.class,
                "El estado del espacio no es válido"
        );
    }

    @Test
    public void estadoValido() {
        BasePrueba.assertValid(() ->
                new EspacioTestDataBuilder().conEstado(EstadoEspacio.INACTIVO.id()).build()
        );
    }

    @Test
    public void validarNombre() {
        BasePrueba.assertThrows(() ->
                        new EspacioTestDataBuilder().conNombre(null).build(),
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el nombre"
        );
    }

    @Test
    public void validarFechaCreacion() {
        BasePrueba.assertValid(() ->
                new EspacioTestDataBuilder().conFechaCreacion(null).build()
        );
    }
}

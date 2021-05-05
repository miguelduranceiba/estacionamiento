package com.ceiba.conductor.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.conductor.servicio.testdatabuilder.ConductorTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Test;

public class ConductorTest {

    @Test
    public void validarInicializacion() {
        BasePrueba.assertValid(() ->
                new ConductorTestDataBuilder().build()
        );
    }

    @Test
    public void validarTipoIdentificacionObligatorio() {
        BasePrueba.assertThrows(() ->
                        new ConductorTestDataBuilder().conTipoIdentificacion(null).build(),
                ExcepcionValorObligatorio.class,
                "Se debe ingresar tipo de identificación"
        );
    }

    @Test
    public void validarNumeroIdentificacionObligatorio() {
        BasePrueba.assertThrows(() ->
                        new ConductorTestDataBuilder().conNumeroIdentificacion(null).build(),
                ExcepcionValorObligatorio.class,
                "Se debe ingresar número de identificación"
        );
    }

    @Test
    public void validarPrimerNombreObligatorio() {
        BasePrueba.assertThrows(() ->
                        new ConductorTestDataBuilder().conPrimerNombre(null).build(),
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el primer nombre"
        );
    }

    @Test
    public void validarSegundoNombreNoObligatorio() {
        BasePrueba.assertValid(() ->
                new ConductorTestDataBuilder().conSegundoNombre(null).build()
        );
    }

    @Test
    public void validarPrimerApellidoObligatorio() {
        BasePrueba.assertThrows(() ->
                        new ConductorTestDataBuilder().conPrimerApellido(null).build(),
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el primer apellido"
        );
    }

    @Test
    public void validarSegundoApellidoNoObligatorio() {
        BasePrueba.assertValid(() ->
                new ConductorTestDataBuilder().conSegundoApellido(null).build()
        );
    }


}

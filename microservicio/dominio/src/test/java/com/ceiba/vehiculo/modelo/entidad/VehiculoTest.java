package com.ceiba.vehiculo.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Test;

public class VehiculoTest {

    @Test
    public void inicializarObjetoValido() {
        BasePrueba.assertValid(() -> new VehiculoTestDataBuilder().build());
    }

    @Test
    public void excepcionPlacaObligatorio() {
        BasePrueba.assertThrows(() -> new VehiculoTestDataBuilder().conPlaca(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar la placa del vehículo");
    }

    @Test
    public void excepcionTipoVehiculoObligatorio() {
        BasePrueba.assertThrows(() -> new VehiculoTestDataBuilder().conTipoVehiculo(null).build(), ExcepcionValorObligatorio.class, "Se debe diligenciar el tipo del vehículo");
    }

    @Test
    public void excepcionFechaCreacionObligatorio() {
        BasePrueba.assertValid(() -> new VehiculoTestDataBuilder().conFechaCreacion(null).build());
    }

    @Test
    public void excepcionPlacaMenor6Caracteres() {
        BasePrueba.assertThrows(() -> new VehiculoTestDataBuilder().conPlaca("PLA0").build(), ExcepcionLongitudValor.class, "La placa debe tener una longitud mayor o igual a 5");
    }

    @Test
    public void excepcionPlacaConEspacio() {
        BasePrueba.assertThrows(() -> new VehiculoTestDataBuilder().conPlaca("PLA 001").build(), ExcepcionValorInvalido.class, "La placa no debe contener caracteres especiales y espacios");
    }

    @Test
    public void excepcionPlacaConCaracteresNoAlfanumericos() {
        BasePrueba.assertThrows(() -> new VehiculoTestDataBuilder().conPlaca("PLA@01").build(), ExcepcionValorInvalido.class, "La placa no debe contener caracteres especiales y espacios");
    }
}

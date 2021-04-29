package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearVehiculoTest {

    private static final String PLACA_MIG001 = "MIG001";

    @Test
    public void validarPlacaLongitudMenor5Test() {
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca("MIG1");

        BasePrueba.assertThrows(() -> vehiculoTestDataBuilder.build(), ExcepcionLongitudValor.class, Vehiculo.mensajeLongitudPlaca());
    }

    @Test
    public void validarPlacaLongitudIgualA6Test() {
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_MIG001);
        try {
            Vehiculo vehiculo = vehiculoTestDataBuilder.build();
            Assert.assertTrue(vehiculo.isEqualsPlaca(PLACA_MIG001));
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void validarPlacaNoDebeContenerCaracteresEspecialesTest() {
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca("MIG-001");

        BasePrueba.assertThrows(() -> vehiculoTestDataBuilder.build(), ExcepcionValorInvalido.class, Vehiculo.LA_PLACA_NO_DEBE_TENER_CARACTERES_ESPECIALES_Y_ESPACIOS);
    }

    @Test
    public void placaSinCaracteresEspecialesTest() {
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_MIG001);

        try {
            Vehiculo vehiculo = vehiculoTestDataBuilder.build();
            Assert.assertTrue(vehiculo.isEqualsPlaca(PLACA_MIG001));
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void validarVehiculoNoExistaPreviaTest() {
        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
        BasePrueba.assertThrows(() -> servicioCrearVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class, ServicioCrearVehiculo.EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
    }
}

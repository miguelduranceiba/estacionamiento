package com.ceiba.ocupacion.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.diaFestivo.modelo.entidad.Festivo;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.ocupacion.servicio.testdatabuilder.OcupacionTestDataBuilder;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.tipoVehiculo.modelo.enumerado.TipoVehiculo;
import com.ceiba.tipoVehiculo.servicio.testdatabuilder.TipoVehiculoTestDataBuilder;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OcupacionTest {

    @Test
    public void validarInicializacionOcupacion() {
        BasePrueba.assertValid(() -> new OcupacionTestDataBuilder().build());
    }

    @Test
    public void excepcionEspacioObligatorio() {
        BasePrueba.assertThrows(() -> new OcupacionTestDataBuilder().conEspacio(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar el espacio");
    }

    @Test
    public void excepcionConductorObligatorio() {
        BasePrueba.assertThrows(() -> new OcupacionTestDataBuilder().conConductor(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar el conductor");
    }

    @Test
    public void excepcionVehiculoObligatorio() {
        BasePrueba.assertThrows(() -> new OcupacionTestDataBuilder().conVehiculo(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar el vehículo");
    }

    @Test
    public void excepcionReservaNoObligatorio() {
        BasePrueba.assertValid(() -> new OcupacionTestDataBuilder().conReserva(null).build());
    }

    @Test
    public void excepcionReservaNoObligatorioDiligenciado() {
        BasePrueba.assertValid(() -> new OcupacionTestDataBuilder().conReserva(new ReservaTestDataBuilder()).build());
    }

    @Test
    public void excepcionFechaInicioObligatorio() {
        BasePrueba.assertThrows(() -> new OcupacionTestDataBuilder().conFechaInicio(null).build(), ExcepcionValorObligatorio.class, "Se debe ingresar la fecha inicio");
    }

    @Test
    public void excepcionFechaFinNoObligatorio() {
        BasePrueba.assertValid(() -> new OcupacionTestDataBuilder().conFechaFin(null).build());
    }

    @Test
    public void excepcionFechaFinNoObligatorioDiligenciado() {
        BasePrueba.assertValid(() -> new OcupacionTestDataBuilder().conFechaFin(LocalDateTime.now()).build());
    }

    @Test
    public void validarFinalizarFestivoReserva() {

        LocalDateTime fechaFestivo = LocalDateTime.now().minusHours(3);

        TipoVehiculoTestDataBuilder tipoVehiculo = new TipoVehiculoTestDataBuilder().conValor(new BigDecimal(5000));
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder().conTipoVehiculo(tipoVehiculo);
        ReservaTestDataBuilder reserva = new ReservaTestDataBuilder();
        Ocupacion ocupacion = new OcupacionTestDataBuilder().conReserva(reserva).conVehiculo(vehiculo).conFechaInicio(fechaFestivo).build();

        List<Festivo> listaFestivo = new ArrayList<>();
        listaFestivo.add(new Festivo(1L, fechaFestivo));

        ocupacion.finalizar(listaFestivo);

        Assert.assertTrue(ocupacion.isTotal(new BigDecimal(30000)));
    }

    @Test
    public void validarPagarOcupacionFestivoSinReserva() {

        LocalDateTime fechaFestivo = LocalDateTime.now().minusHours(3);

        TipoVehiculoTestDataBuilder tipoVehiculo = new TipoVehiculoTestDataBuilder().conValor(new BigDecimal(5000));
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder().conTipoVehiculo(tipoVehiculo);
        Ocupacion ocupacion = new OcupacionTestDataBuilder().conVehiculo(vehiculo).conFechaInicio(fechaFestivo).build();

        List<Festivo> listaFestivo = new ArrayList<>();
        listaFestivo.add(new Festivo(1L, fechaFestivo));

        ocupacion.finalizar(listaFestivo);

        Assert.assertTrue(ocupacion.isTotal(new BigDecimal(15000)));
    }

    @Test
    public void validarFinalizarCuandoTipoMotocicleta() {

        LocalDateTime fechaFestivo = LocalDateTime.now().minusHours(3);

        TipoVehiculoTestDataBuilder tipoVehiculo = new TipoVehiculoTestDataBuilder().conId(TipoVehiculo.MOTOCICLETA.id()).conValor(new BigDecimal(1000));
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder().conTipoVehiculo(tipoVehiculo);
        Ocupacion ocupacion = new OcupacionTestDataBuilder().conVehiculo(vehiculo).conFechaInicio(fechaFestivo).build();

        ocupacion.finalizar(null);

        Assert.assertTrue(ocupacion.isTotal(new BigDecimal(2700)));
    }

    @Test
    public void validarFinalizarCuandoTipoMotocicletaYReserva() {

        LocalDateTime fechaFestivo = LocalDateTime.now().minusHours(3);

        TipoVehiculoTestDataBuilder tipoVehiculo = new TipoVehiculoTestDataBuilder().conId(TipoVehiculo.MOTOCICLETA.id()).conValor(new BigDecimal(1000));
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder().conTipoVehiculo(tipoVehiculo);
        ReservaTestDataBuilder reserva = new ReservaTestDataBuilder();
        Ocupacion ocupacion = new OcupacionTestDataBuilder().conReserva(reserva).conVehiculo(vehiculo).conFechaInicio(fechaFestivo).build();

        List<Festivo> listaFestivo = new ArrayList<>();
        listaFestivo.add(new Festivo(1L, fechaFestivo));

        ocupacion.finalizar(listaFestivo);

        Assert.assertTrue(ocupacion.isTotal(new BigDecimal(5400)));
    }

    @Test
    public void validarFinalizarCuandoTipoMotocicletaYReservaSinDiaFestivo() {

        LocalDateTime fechaFestivo = LocalDateTime.now().minusHours(3);

        TipoVehiculoTestDataBuilder tipoVehiculo = new TipoVehiculoTestDataBuilder().conId(TipoVehiculo.MOTOCICLETA.id()).conValor(new BigDecimal(1000));
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder().conTipoVehiculo(tipoVehiculo);
        ReservaTestDataBuilder reserva = new ReservaTestDataBuilder();
        Ocupacion ocupacion = new OcupacionTestDataBuilder().conReserva(reserva).conVehiculo(vehiculo).conFechaInicio(fechaFestivo).build();

        List<Festivo> listaFestivo = new ArrayList<>();

        ocupacion.finalizar(listaFestivo);

        Assert.assertTrue(ocupacion.isTotal(new BigDecimal(2700)));
    }
}

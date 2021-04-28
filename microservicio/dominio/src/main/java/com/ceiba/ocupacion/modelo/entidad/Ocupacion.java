package com.ceiba.ocupacion.modelo.entidad;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.diaFestivo.modelo.entidad.Festivo;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.tipoVehiculo.modelo.enumerado.TipoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Ocupacion {

    private final double DESCUENTO_MOTOCICLETA = 0.90;

    private static final String SE_DEBE_INGRESAR_VEHICULO = "Se debe ingresar el vehículo";
    private static final String SE_DEBE_INGRESAR_CONDUCTOR = "Se debe ingresar el conductor";
    private static final String SE_DEBE_INGRESAR_ESPACIO = "Se debe ingresar el espacio";
    private static final String SE_DEBE_INGRESAR_FECHA_INICIO = "Se debe ingresar la fecha inicio";
    private long id;
    private Espacio espacio;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private Reserva reserva;
    private BigDecimal total;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Ocupacion(long id, Espacio espacio, Conductor conductor, Vehiculo vehiculo, Reserva reserva, BigDecimal total, LocalDateTime fechaInicio, LocalDateTime fechaFin) {

        validarObligatorio(espacio, SE_DEBE_INGRESAR_ESPACIO);
        validarObligatorio(conductor, SE_DEBE_INGRESAR_CONDUCTOR);
        validarObligatorio(vehiculo, SE_DEBE_INGRESAR_VEHICULO);
        validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_FECHA_INICIO);

        this.id = id;
        this.espacio = espacio;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.reserva = reserva;
        this.total = total;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public void finalizar(List<Festivo> listaDiaFestivo) {
        BigDecimal cantidadHoras = calcularHorasParqueo();
        this.total = getVehiculo().getTipoVehiculo().getValor().multiply(cantidadHoras);
        if (getVehiculo().getTipoVehiculo().getId() == TipoVehiculo.MOTOCICLETA.id()) {
            this.total = this.total.multiply(new BigDecimal(DESCUENTO_MOTOCICLETA));
        }
        calcularDiaFestivo(listaDiaFestivo);
    }

    private void calcularDiaFestivo(List<Festivo> listaDiaFestivo) {
        if (reserva != null) {
            long cantidad = listaDiaFestivo.stream().filter(festivo -> festivo.getDia().compareTo(fechaInicio) == 0).count();
            if (cantidad > 0) {
                this.total = this.total.add(this.total);
            }
        }
    }

    private BigDecimal calcularHorasParqueo() {
        this.fechaFin = LocalDateTime.now();
        Duration duration = Duration.between(getFechaInicio(), fechaFin);
        BigDecimal cantidadHoras = new BigDecimal(duration.toHours());
        return cantidadHoras;
    }

    public boolean tieneReserva() {
        return reserva != null;
    }
}

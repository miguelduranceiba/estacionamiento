package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ServicioCrearReserva {

    public static final String YA_EXISTE_UNA_RESERVA_PARA_EL_RANGO_TIEMPO = "Ya existe una reserva para el rango de tiempo";
    private static final String NO_SE_PUEDEN_HACER_RESERVAS_LOS_SABADOS_Y_DOMINGOS = "No se pueden hacer reservas los sábados y domingos";
    private static final String EL_RANGO_RESERVA_DEBE_SER_EL_MISMO_DIA = "El rango de la reserva debe ser en el mismo día";
    private final RepositorioReserva repositorioReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Long ejecutar(Reserva reserva) {
        LocalDateTime fechaInicio = reserva.getFechaInicio();
        LocalDateTime fechaFin = reserva.getFechaFin();

        validarNoExistaReserva(fechaInicio, fechaFin);
        validarDiaDiferenteEntreFecha(fechaInicio, fechaFin);
        validarNoReservarFinSemana(fechaInicio);
        reserva.reservar();

        return this.repositorioReserva.crear(reserva);
    }

    private void validarNoExistaReserva(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        boolean existe = repositorioReserva.existe(fechaInicio, fechaFin);
        if (existe) {
            throw new ExcepcionDuplicidad(YA_EXISTE_UNA_RESERVA_PARA_EL_RANGO_TIEMPO);
        }
    }

    private void validarNoReservarFinSemana(LocalDateTime fecha) {
        boolean correcto = fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY;
        if (correcto) {
            throw new ExcepcionValorInvalido(NO_SE_PUEDEN_HACER_RESERVAS_LOS_SABADOS_Y_DOMINGOS);
        }
    }

    private void validarDiaDiferenteEntreFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        boolean correcto = fechaInicio.compareTo(fechaFin) != 0;
        if (correcto) {
            throw new ExcepcionValorInvalido(EL_RANGO_RESERVA_DEBE_SER_EL_MISMO_DIA);
        }
    }
}

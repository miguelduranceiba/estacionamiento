package com.ceiba.vehiculo.modelo.entidad;

import com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Vehiculo {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa del vehículo";
    private static final int LONGITUD_MINIMA_PLACA = 6;
    private static final String LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_O_MAYOR_A = "La placa debe tener una longitud mayor o igual a %s ";
    public static final String LA_PLACA_NO_DEBE_TENER_CARACTERES_ESPECIALES_Y_ESPACIOS = "La placa no debe contener caracteres especiales y espacios";
    private static final String SE_DEBE_INGRESAR_TIPO_VEHICULO = "Se debe diligenciar el tipo del vehículo";

    private Long id;
    private String placa;
    private TipoVehiculo tipoVehiculo;
    private LocalDateTime fechaCreacion;

    public Vehiculo(Long id, String placa, TipoVehiculo tipoVehiculo, LocalDateTime fechaCreacion) {

        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarObligatorio(tipoVehiculo, SE_DEBE_INGRESAR_TIPO_VEHICULO);
        validarLongitud(placa, LONGITUD_MINIMA_PLACA, mensajeLongitudPlaca());
        validarNumeroYLetra(placa, LA_PLACA_NO_DEBE_TENER_CARACTERES_ESPECIALES_Y_ESPACIOS);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaCreacion = fechaCreacion;
    }

    public static String mensajeLongitudPlaca() {
        return String.format(LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_O_MAYOR_A, LONGITUD_MINIMA_PLACA);
    }

    public boolean isEqualsPlaca(String placa) {
        return this.placa.equals(placa);
    }
}

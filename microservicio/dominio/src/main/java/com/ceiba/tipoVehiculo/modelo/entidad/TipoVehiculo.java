package com.ceiba.tipoVehiculo.modelo.entidad;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TipoVehiculo {

    private static final String SE_DEBE_INGRESAR_EL_VALOR = "Se debe ingresar el valor";

    private int id;
    private BigDecimal valor;

    public TipoVehiculo(int id, BigDecimal valor) {

        validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR);

        this.id = id;
        this.valor = valor;
    }
}

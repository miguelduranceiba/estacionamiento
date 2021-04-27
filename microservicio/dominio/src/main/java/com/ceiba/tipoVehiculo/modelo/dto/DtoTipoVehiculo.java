package com.ceiba.tipoVehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoTipoVehiculo {

    private int id;
    private BigDecimal valor;

}

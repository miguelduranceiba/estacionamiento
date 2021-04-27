package com.ceiba.vehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoVehiculo {
    private Long id;
    private String placa;
    private Integer tipoVehiculo;
    private LocalDateTime fechaCreacion;
}

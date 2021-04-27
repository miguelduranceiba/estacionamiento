package com.ceiba.ocupacion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoOcupacion {

    private long id;
    private long idEspacio;
    private long idConductor;
    private long idVehiculo;
    private BigDecimal total;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

}

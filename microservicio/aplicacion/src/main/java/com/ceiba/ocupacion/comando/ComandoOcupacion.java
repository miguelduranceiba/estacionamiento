package com.ceiba.ocupacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoOcupacion {

    private long id;
    private long idEspacio;
    private long idConductor;
    private long idVehiculo;
    private Long idReserva;
    private BigDecimal total;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public boolean tieneReserva() {
        return idReserva != null;
    }
}

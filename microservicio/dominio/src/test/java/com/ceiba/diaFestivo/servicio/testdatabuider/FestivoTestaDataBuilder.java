package com.ceiba.diaFestivo.servicio.testdatabuider;

import com.ceiba.diaFestivo.modelo.entidad.Festivo;

import java.time.LocalDateTime;

public class FestivoTestaDataBuilder {

    private Long id;
    private LocalDateTime dia;

    public FestivoTestaDataBuilder() {
        dia = LocalDateTime.now();
    }

    public FestivoTestaDataBuilder conDia(LocalDateTime dia) {
        this.dia = dia;
        return this;
    }

    public Festivo build() {
        return new Festivo(this.id, this.dia);
    }

}

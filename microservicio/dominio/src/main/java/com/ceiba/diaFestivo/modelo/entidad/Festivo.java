package com.ceiba.diaFestivo.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

@Getter
public class Festivo {

    private static final String SE_DEBE_INGRESAR_DIA_FESTIVO = "Se debe ingresar el día festivo";
    private Long id;
    private LocalDateTime dia;

    public Festivo(Long id, LocalDateTime dia) {

        validarObligatorio(dia, SE_DEBE_INGRESAR_DIA_FESTIVO);

        this.id = id;
        this.dia = dia;
    }
}

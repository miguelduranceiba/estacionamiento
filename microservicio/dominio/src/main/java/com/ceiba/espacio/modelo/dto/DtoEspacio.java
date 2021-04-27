package com.ceiba.espacio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoEspacio {

    private long id;
    private String nombre;
    private short estado;
    private LocalDateTime fechaCreacion;

}

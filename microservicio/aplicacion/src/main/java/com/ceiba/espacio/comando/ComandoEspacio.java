package com.ceiba.espacio.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEspacio {

    private long id;
    private String nombre;
    private int estado;
    private LocalDateTime fechaCreacion;

}

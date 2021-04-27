package com.ceiba.diaFestivo.puerto.repositorio;

import com.ceiba.diaFestivo.modelo.entidad.Festivo;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositorioFestivo {

    /**
     * Permite listar los días festivos
     *
     * @return
     */
    List<Festivo> listar();

}

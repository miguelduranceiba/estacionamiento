package com.ceiba.diaFestivo.adaptador.repositorio;

import com.ceiba.diaFestivo.modelo.entidad.Festivo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoFestivo implements RowMapper<Festivo>, MapperResult {
    @Override
    public Festivo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "dia");

        return new Festivo(id, fecha);
    }
}

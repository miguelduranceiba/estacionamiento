package com.ceiba.espacio.adaptador.dao;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoEspacio implements RowMapper<DtoEspacio>, MapperResult {
    @Override
    public DtoEspacio mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        short estado = resultSet.getShort("estado");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoEspacio(id, nombre, estado, fecha);
    }
}

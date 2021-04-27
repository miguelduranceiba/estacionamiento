package com.ceiba.espacio.adaptador.repositorio;

import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoEspacio implements RowMapper<Espacio>, MapperResult {
    @Override
    public Espacio mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        int estado = resultSet.getInt("estado");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new Espacio(id, estado, nombre, fecha);
    }
}

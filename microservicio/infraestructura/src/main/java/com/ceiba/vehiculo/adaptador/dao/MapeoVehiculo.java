package com.ceiba.vehiculo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoVehiculo implements RowMapper<DtoVehiculo>, MapperResult {

    @Override
    public DtoVehiculo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String placa = resultSet.getString("placa");
        int tipoVehiculo = resultSet.getInt("id_tipo_vehiculo");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoVehiculo(id, placa, tipoVehiculo, fecha);
    }
}

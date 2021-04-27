package com.ceiba.tipoVehiculo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoTipoVehiculo implements RowMapper<TipoVehiculo>, MapperResult {

    @Override
    public TipoVehiculo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        BigDecimal valor = resultSet.getBigDecimal("valor");

        return new TipoVehiculo(id, valor);
    }
}

package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {
    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        long id = resultSet.getLong("id");
        long idVehiculo = resultSet.getLong("id_vehiculo");
        long idConductor = resultSet.getLong("id_conductor");
        long idEspacio = resultSet.getLong("id_espacio");
        short estado = resultSet.getShort("estado");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet, "fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(resultSet, "fecha_fin");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoReserva(id,
                idVehiculo,
                idConductor,
                idEspacio,
                estado,
                fechaInicio,
                fechaFin,
                fechaCreacion);
    }
}

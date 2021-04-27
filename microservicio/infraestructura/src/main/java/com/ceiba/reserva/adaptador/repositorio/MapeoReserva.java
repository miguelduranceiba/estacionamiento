package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoReserva implements RowMapper<Reserva>, MapperResult {
    @Override
    public Reserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        long id = resultSet.getLong("id");
        long idVehiculo = resultSet.getLong("id_vehiculo");
        long idConductor = resultSet.getLong("id_conductor");
        long idEspacio = resultSet.getLong("id_espacio");
        int estado = resultSet.getInt("estado");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet, "fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(resultSet, "fecha_fin");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new Reserva(id,
                idVehiculo,
                idConductor,
                idEspacio,
                estado,
                fechaInicio,
                fechaFin,
                fechaCreacion);
    }
}

package com.ceiba.ocupacion.adaptador.dao;

import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.ocupacion.modelo.dto.DtoOcupacion;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoOcupacion implements RowMapper<DtoOcupacion>, MapperResult {

    @Override
    public DtoOcupacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        long idEspacio = resultSet.getLong("id_espacio");
        long idConductor = resultSet.getLong("id_conductor");
        long idVehiculo = resultSet.getLong("id_vehiculo");
        BigDecimal total = resultSet.getBigDecimal("total");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet, "fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(resultSet, "fecha_fin");

        return new DtoOcupacion(id, idEspacio, idConductor, idVehiculo, total, fechaInicio, fechaFin);
    }
}

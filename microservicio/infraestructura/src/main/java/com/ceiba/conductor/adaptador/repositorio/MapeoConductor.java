package com.ceiba.conductor.adaptador.repositorio;

import com.ceiba.conductor.modelo.dto.DtoConductor;
import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoConductor implements RowMapper<Conductor>, MapperResult {

    @Override
    public Conductor mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String tipoIdentificacion = resultSet.getString("tipo_identificacion");
        String numeroIdentificacion = resultSet.getString("numero_identificacion");
        String primerNombre = resultSet.getString("primer_nombre");
        String segundoNombre = resultSet.getString("segundo_nombre");
        String primerApellido = resultSet.getString("primer_apellido");
        String segundoApellido = resultSet.getString("segundo_apellido");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new Conductor(id, tipoIdentificacion, numeroIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, fecha);
    }

}

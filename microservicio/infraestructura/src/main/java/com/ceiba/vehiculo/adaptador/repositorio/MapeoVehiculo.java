package com.ceiba.vehiculo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo;
import com.ceiba.tipoVehiculo.puerto.repositorio.RepositorioTipoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoVehiculo implements RowMapper<Vehiculo>, MapperResult {

    private final RepositorioTipoVehiculo repositorioTipoVehiculo;

    public MapeoVehiculo(RepositorioTipoVehiculo repositorioTipoVehiculo) {
        this.repositorioTipoVehiculo = repositorioTipoVehiculo;
    }

    @Override
    public Vehiculo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String placa = resultSet.getString("placa");
        long tipo = resultSet.getLong("id_tipo_vehiculo");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        TipoVehiculo tipoVehiculo = repositorioTipoVehiculo.consultarPorId(tipo);

        return new Vehiculo(id, placa, tipoVehiculo, fecha);
    }
}

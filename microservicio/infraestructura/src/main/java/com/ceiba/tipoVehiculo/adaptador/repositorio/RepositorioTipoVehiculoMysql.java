package com.ceiba.tipoVehiculo.adaptador.repositorio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipoVehiculo.modelo.entidad.TipoVehiculo;
import com.ceiba.tipoVehiculo.puerto.repositorio.RepositorioTipoVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTipoVehiculoMysql implements RepositorioTipoVehiculo {

    private static final String NO_SE_ENCONTRO_TIPO_VEHICULO = "No se encontró el tipo del vehículo en el sistema";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "tipo_vehiculo", value = "listarPorId")
    private static String sqlListarPorId;

    public RepositorioTipoVehiculoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public TipoVehiculo consultarPorId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorId, paramSource,
                new MapeoTipoVehiculo()).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(NO_SE_ENCONTRO_TIPO_VEHICULO));
    }
}

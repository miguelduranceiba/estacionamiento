package com.ceiba.vehiculo.adaptador.dao;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoVehiculoMysql implements DaoVehiculo {

    private static final String VEHICULO_NO_ENCONTRADO = "El vehículo no se encontró";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "vehiculo", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "vehiculo", value = "listarPorPlaca")
    private static String sqlListarPorPlaca;

    @SqlStatement(namespace = "vehiculo", value = "listarPorId")
    private static String sqlListarPorId;

    public DaoVehiculoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoVehiculo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
                new MapeoVehiculo());
    }

    @Override
    public DtoVehiculo consultarPorPlaca(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorPlaca, paramSource,
                new MapeoVehiculo()).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(VEHICULO_NO_ENCONTRADO));
    }

}

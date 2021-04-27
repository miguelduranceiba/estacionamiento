package com.ceiba.vehiculo.adaptador.repositorio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipoVehiculo.puerto.repositorio.RepositorioTipoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVehiculoMysql implements RepositorioVehiculo {

    private static final String VEHICULO_NO_SE_ENCONTRO = " No se encontró el vehículo en el sistema";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final RepositorioTipoVehiculo repositorioTipoVehiculo;

    @SqlStatement(namespace = "vehiculo", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "vehiculo", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "vehiculo", value = "listarPorId")
    private static String sqlListarPorId;


    public RepositorioVehiculoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, RepositorioTipoVehiculo repositorioTipoVehiculo) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.repositorioTipoVehiculo = repositorioTipoVehiculo;
    }

    @Override
    public Long crear(Vehiculo vehiculo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", vehiculo.getPlaca());
        paramSource.addValue("idTipoVehiculo", vehiculo.getTipoVehiculo().getId());
        paramSource.addValue("fechaCreacion", vehiculo.getFechaCreacion());

        return this.customNamedParameterJdbcTemplate.crear(sqlCrear, paramSource);
    }


    @Override
    public boolean existe(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public Vehiculo consultarPorId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorId, paramSource,
                new MapeoVehiculo(repositorioTipoVehiculo)).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(VEHICULO_NO_SE_ENCONTRO));
    }


}

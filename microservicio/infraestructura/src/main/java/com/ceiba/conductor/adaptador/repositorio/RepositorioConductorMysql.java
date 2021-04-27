package com.ceiba.conductor.adaptador.repositorio;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioConductorMysql implements RepositorioConductor {

    private static final String CONDUCTOR_NO_ENCONTRADA = "No se encontro el conductor en el sistema";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "conductor", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "conductor", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "conductor", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "conductor", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "conductor", value = "listarPorId")
    private static String sqlListarPorId;

    public RepositorioConductorMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Conductor conductor) {
        return this.customNamedParameterJdbcTemplate.crear(conductor, sqlCrear);
    }

    @Override
    public boolean existe(String tipoIdentificacion, String numeroIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoIdentificacion", tipoIdentificacion);
        paramSource.addValue("numeroIdentificacion", numeroIdentificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public int actualizar(Conductor conductor) {
        return this.customNamedParameterJdbcTemplate.actualizar(conductor, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String tipoIdentificacion, String numeroIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("tipoIdentificacion", tipoIdentificacion);
        paramSource.addValue("numeroIdentificacion", numeroIdentificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }

    @Override
    public Conductor consultarPorId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorId, paramSource,
                new MapeoConductor()).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(CONDUCTOR_NO_ENCONTRADA));
    }
}

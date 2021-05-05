package com.ceiba.ocupacion.adaptador.dao;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ocupacion.modelo.dto.DtoOcupacion;
import com.ceiba.ocupacion.puerto.dao.DaoOcupacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoOcupacionMysql implements DaoOcupacion {

    private static final String OCUPACION_NO_ENCONTRADO = "Ocupación no encontrada";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "ocupacion", value = "listar")
    private String sqlListar;

    @SqlStatement(namespace = "ocupacion", value = "listarPorEspacioYActivo")
    private String sqlListarPorEspacioYActivo;

    public DaoOcupacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoOcupacion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
                new MapeoOcupacion());
    }

    @Override
    public DtoOcupacion consultarPorEstadoYActivo(long idEspacio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEspacio", idEspacio);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorEspacioYActivo, paramSource,
                new MapeoOcupacion()).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(OCUPACION_NO_ENCONTRADO));
    }
}

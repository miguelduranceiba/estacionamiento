package com.ceiba.conductor.adaptador.dao;

import com.ceiba.conductor.modelo.dto.DtoConductor;
import com.ceiba.conductor.puerto.dao.DaoConductor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoConductorMysql implements DaoConductor {
    private static final String CONDUCTOR_NO_ENCONTRADO = "El conductor no se encontró";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "conductor", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "conductor", value = "consultarPorIdentificacion")
    private static String sqlConsultarPorIdentificacion;

    public DaoConductorMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoConductor> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
                new MapeoConductor());
    }

    @Override
    public DtoConductor consultarPorIdentificacion(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlConsultarPorIdentificacion,
                paramSource, new MapeoConductor()).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(CONDUCTOR_NO_ENCONTRADO));
    }
}

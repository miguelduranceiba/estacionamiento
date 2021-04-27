package com.ceiba.ocupacion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ocupacion.modelo.dto.DtoOcupacion;
import com.ceiba.ocupacion.puerto.dao.DaoOcupacion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoOcupacionMysql implements DaoOcupacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "ocupacion", value = "listar")
    private String sqlListar;

    public DaoOcupacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoOcupacion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
                new MapeoOcupacion());
    }
}

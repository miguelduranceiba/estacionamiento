package com.ceiba.diaFestivo.adaptador.repositorio;

import com.ceiba.diaFestivo.modelo.entidad.Festivo;
import com.ceiba.diaFestivo.puerto.repositorio.RepositorioFestivo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioFestivoMysql implements RepositorioFestivo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "festivo", value = "listar")
    private String sqlListar;

    public RepositorioFestivoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<Festivo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
                new MapeoFestivo());
    }
}

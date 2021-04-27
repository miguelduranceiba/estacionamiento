package com.ceiba.espacio.adaptador.dao;

import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.puerto.dao.DaoEspacio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEspacioMysql implements DaoEspacio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "espacio", value = "listarEspacioDisponible")
    private static String sqlListarEspacioDisponible;

    public DaoEspacioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEspacio> listarEspacioDisponible() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("estado", EstadoEspacio.DISPONIBLE.id());

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarEspacioDisponible, paramSource,
                new MapeoEspacio());
    }
}

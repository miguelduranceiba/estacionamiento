package com.ceiba.espacio.adaptador.dao;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.puerto.dao.DaoEspacio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ocupacion.puerto.dao.DaoOcupacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEspacioMysql implements DaoEspacio {

    private static final String NO_ENCONTRADO_ESPACIO = "El espacio no se encontró";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final DaoOcupacion daoOcupacion;

    @SqlStatement(namespace = "espacio", value = "listarEspacioActivo")
    private static String sqlListarEspacioActivo;

    @SqlStatement(namespace = "espacio", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "espacio", value = "listarPorId")
    private static String sqlConsultarPorId;

    public DaoEspacioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, DaoOcupacion daoOcupacion) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoOcupacion = daoOcupacion;
    }

    @Override
    public List<DtoEspacio> listarEspacioActivo() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("estado", EstadoEspacio.INACTIVO.id());

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarEspacioActivo, paramSource,
                new MapeoEspacio(daoOcupacion));
    }

    @Override
    public List<DtoEspacio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
                new MapeoEspacio(daoOcupacion));
    }

    @Override
    public DtoEspacio consultarPorId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlConsultarPorId, paramSource,
                new MapeoEspacio(daoOcupacion)).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(NO_ENCONTRADO_ESPACIO));
    }
}

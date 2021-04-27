package com.ceiba.espacio.adaptador.repositorio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEspacioMysql implements RepositorioEspacio {
    private static final String ESPACIO_NO_ENCONTRADO = "El espacio no se encontró en el sistema";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "espacio", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "espacio", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "espacio", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "espacio", value = "cambioEstado")
    private static String sqlCambioEstado;

    @SqlStatement(namespace = "espacio", value = "validarEstado")
    private static String sqlValidarEstado;

    @SqlStatement(namespace = "espacio", value = "listarPorId")
    private static String sqlListarPorId;


    public RepositorioEspacioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Espacio espacio) {
        return this.customNamedParameterJdbcTemplate.crear(espacio, sqlCrear);
    }

    @Override
    public int actualizar(Espacio espacio) {
        return this.customNamedParameterJdbcTemplate.actualizar(espacio, sqlActualizar);
    }

    @Override
    public void inactivar(long id) {
        actualizarEstado(id, EstadoEspacio.INACTIVO.id());
    }

    @Override
    public void eliminar(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizarEstado(long id, int estado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("estado", estado);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCambioEstado, paramSource);
    }

    @Override
    public boolean estadoEspacio(long idEspacio, int estado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idEspacio);
        paramSource.addValue("estado", estado);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlValidarEstado, paramSource, Boolean.class);
    }

    @Override
    public Espacio consultarPorId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorId, paramSource,
                new MapeoEspacio()).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(ESPACIO_NO_ENCONTRADO));
    }
}

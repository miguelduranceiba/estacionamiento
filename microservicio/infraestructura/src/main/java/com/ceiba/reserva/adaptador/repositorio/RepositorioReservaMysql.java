package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.modelo.enumerado.EstadoReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private static final String NO_ENCONTRADO_RESERVA = "No se encontró la reserva";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "reserva", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "reserva", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "reserva", value = "cambioEstado")
    private static String sqlCambioEstado;

    @SqlStatement(namespace = "reserva", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "reserva", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "reserva", value = "listarPorId")
    private String sqlListarPorId;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
    }

    @Override
    public int actualizar(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizar);
    }

    @Override
    public void actualizarEstado(long id, int estado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("estado", estado);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCambioEstado, paramSource);
    }

    @Override
    public boolean existe(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaInicio", fechaInicio);
        paramSource.addValue("fechaFin", fechaFin);
        paramSource.addValue("estado", EstadoReserva.RESERVADO.id());

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public boolean existenciaId(long id, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("fechaInicio", fechaInicio);
        paramSource.addValue("fechaFin", fechaFin);
        paramSource.addValue("estado", EstadoReserva.RESERVADO.id());

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }

    @Override
    public Reserva consultarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorId, paramSource,
                new MapeoReserva()).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(NO_ENCONTRADO_RESERVA));
    }
}

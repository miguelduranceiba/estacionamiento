package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.modelo.enumerado.EstadoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.usuario.adaptador.dao.MapeoUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoReservaMysql implements DaoReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "reserva", value = "listarPorVehiculo")
    private static String sqlListarPorVehiculo;

    public DaoReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoReserva> listarReservaPorVehiculo(long idVehiculo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idVehiculo", idVehiculo);
        paramSource.addValue("estado", EstadoReserva.RESERVADO);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorVehiculo, paramSource,
                new MapeoReserva());
    }
}

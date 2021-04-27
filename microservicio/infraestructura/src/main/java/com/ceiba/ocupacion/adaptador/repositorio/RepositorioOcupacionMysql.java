package com.ceiba.ocupacion.adaptador.repositorio;

import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOcupacionMysql implements RepositorioOcupacion {

    private static final String OCUPACION_NO_ENCONTRADA = "No se encontró una ocupación";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioEspacio repositorioEspacio;
    private final RepositorioConductor repositorioConductor;
    private final RepositorioReserva repositorioReserva;

    @SqlStatement(namespace = "ocupacion", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "ocupacion", value = "existeEspacioPorId")
    private static String sqlExisteEspacioPorId;

    @SqlStatement(namespace = "ocupacion", value = "pagar")
    private static String sqlPagar;

    @SqlStatement(namespace = "ocupacion", value = "listarOcupacionPorId")
    private static String sqlListarPorId;

    public RepositorioOcupacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, RepositorioVehiculo repositorioVehiculo, RepositorioEspacio repositorioEspacio, RepositorioConductor repositorioConductor, RepositorioReserva repositorioReserva) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioEspacio = repositorioEspacio;
        this.repositorioConductor = repositorioConductor;
        this.repositorioReserva = repositorioReserva;
    }

    @Override
    public Long crear(Ocupacion ocupacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idConductor", ocupacion.getConductor().getId());
        paramSource.addValue("idVehiculo", ocupacion.getVehiculo().getId());
        paramSource.addValue("idEspacio", ocupacion.getEspacio().getId());
        if (ocupacion.tieneReserva()) {
            paramSource.addValue("idReserva", ocupacion.getReserva().getId());
        }
        paramSource.addValue("total", ocupacion.getTotal());
        paramSource.addValue("fechaInicio", ocupacion.getFechaInicio());
        paramSource.addValue("fechaFin", ocupacion.getFechaFin());

        return this.customNamedParameterJdbcTemplate.crear(sqlCrear, paramSource);
    }

    @Override
    public boolean existeEspacioPorId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEspacio", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteEspacioPorId, paramSource, Boolean.class);
    }

    @Override
    public void pagar(Ocupacion ocupacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", ocupacion.getId());
        paramSource.addValue("fechaFin", ocupacion.getFechaFin());
        paramSource.addValue("total", ocupacion.getTotal());

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlPagar, paramSource);
    }

    @Override
    public Ocupacion consultarPorId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorId, paramSource,
                new MapeoOcupacion(repositorioVehiculo, repositorioEspacio, repositorioConductor, repositorioReserva)).stream().findFirst().orElseThrow(() -> new ExcepcionSinDatos(OCUPACION_NO_ENCONTRADA));
    }
}

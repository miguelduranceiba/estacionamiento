package com.ceiba.ocupacion.adaptador.repositorio;

import com.ceiba.conductor.modelo.entidad.Conductor;
import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.ocupacion.modelo.entidad.Ocupacion;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoOcupacion implements RowMapper<Ocupacion>, MapperResult {
    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioEspacio repositorioEspacio;
    private final RepositorioConductor repositorioConductor;
    private final RepositorioReserva repositorioReserva;

    public MapeoOcupacion(RepositorioVehiculo repositorioVehiculo, RepositorioEspacio repositorioEspacio, RepositorioConductor repositorioConductor, RepositorioReserva repositorioReserva) {
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioEspacio = repositorioEspacio;
        this.repositorioConductor = repositorioConductor;
        this.repositorioReserva = repositorioReserva;
    }

    @Override
    public Ocupacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        long idEspacio = resultSet.getLong("id_espacio");
        long idConductor = resultSet.getLong("id_conductor");
        long idVehiculo = resultSet.getLong("id_vehiculo");
        Long idReserva = resultSet.getLong("id_reserva");
        BigDecimal total = resultSet.getBigDecimal("id_vehiculo");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet, "fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(resultSet, "fecha_fin");

        Espacio espacio = repositorioEspacio.consultarPorId(idEspacio);
        Conductor conductor = repositorioConductor.consultarPorId(idConductor);
        Vehiculo vehiculo = repositorioVehiculo.consultarPorId(idVehiculo);
        Reserva reserva = null;
        if (idReserva != null) reserva = repositorioReserva.consultarPorId(idReserva);

        return new Ocupacion(id, espacio, conductor, vehiculo, reserva, total, fechaInicio, fechaFin);
    }
}

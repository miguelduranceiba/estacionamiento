package com.ceiba.espacio.adaptador.dao;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.modelo.enumerado.EstadoEspacio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.ocupacion.modelo.dto.DtoOcupacion;
import com.ceiba.ocupacion.puerto.dao.DaoOcupacion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoEspacio implements RowMapper<DtoEspacio>, MapperResult {

    private final DaoOcupacion daoOcupacion;

    public MapeoEspacio(DaoOcupacion daoOcupacion) {
        this.daoOcupacion = daoOcupacion;
    }

    @Override
    public DtoEspacio mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        short estado = resultSet.getShort("estado");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
        Long idOcupacion = null;

        if (estado == EstadoEspacio.OCUPADO.id()) {
            DtoOcupacion ocupacion = daoOcupacion.consultarPorEstadoYActivo(id);
            if (ocupacion != null) {
                idOcupacion = ocupacion.getId();
            }
        }

        return new DtoEspacio(id, nombre, estado, idOcupacion, fecha);
    }
}

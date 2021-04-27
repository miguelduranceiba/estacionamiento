package com.ceiba.vehiculo.consulta;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarVehiculo {

    private final DaoVehiculo daoVehiculo;

    public ManejadorListarVehiculo(DaoVehiculo daoVehiculo) {
        this.daoVehiculo = daoVehiculo;
    }

    public List<DtoVehiculo> ejecutar() {
        return daoVehiculo.listar();
    }
}

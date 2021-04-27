package com.ceiba.vehiculo.consulta;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarVehiculoPorPlaca {

    private final DaoVehiculo daoVehiculo;

    public ManejadorListarVehiculoPorPlaca(DaoVehiculo daoVehiculo) {
        this.daoVehiculo = daoVehiculo;
    }

    public DtoVehiculo ejecutar(String placa) {
        return daoVehiculo.consultarPorPlaca(placa);
    }
}

package com.ceiba.configuracion;

import com.ceiba.conductor.puerto.repositorio.RepositorioConductor;
import com.ceiba.conductor.servicio.ServicioActualizarConductor;
import com.ceiba.conductor.servicio.ServicioCrearConductor;
import com.ceiba.diaFestivo.puerto.repositorio.RepositorioFestivo;
import com.ceiba.espacio.puerto.respositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.ServicioActualizarEspacio;
import com.ceiba.espacio.servicio.ServicioCrearEspacio;
import com.ceiba.espacio.servicio.ServicioEliminarEspacio;
import com.ceiba.ocupacion.puerto.repositorio.RepositorioOcupacion;
import com.ceiba.ocupacion.servicio.ServicioCrearOcupacion;
import com.ceiba.ocupacion.servicio.ServicioPagarOcupacion;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import com.ceiba.reserva.servicio.ServicioCancelarReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
        return new ServicioCrearVehiculo(repositorioVehiculo);
    }

    @Bean
    public ServicioCrearConductor servicioCrearConductor(RepositorioConductor repositorioConductor) {
        return new ServicioCrearConductor(repositorioConductor);
    }

    @Bean
    public ServicioActualizarConductor servicioActualizarConductor(RepositorioConductor repositorioConductor) {
        return new ServicioActualizarConductor(repositorioConductor);
    }

    @Bean
    public ServicioCrearOcupacion servicioCrearOcupacion(RepositorioOcupacion repositorioOcupacion, RepositorioEspacio repositorioEspacio, RepositorioReserva repositorioReserva) {
        return new ServicioCrearOcupacion(repositorioOcupacion, repositorioEspacio, repositorioReserva);
    }

    @Bean
    public ServicioActualizarReserva servicioActualizarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioActualizarReserva(repositorioReserva);
    }

    @Bean
    public ServicioCancelarReserva servicioCancelarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioCancelarReserva(repositorioReserva);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva) {
        return new ServicioCrearReserva(repositorioReserva);
    }

    @Bean
    public ServicioCrearEspacio servicioCrearEspacio(RepositorioEspacio repositorioEspacio) {
        return new ServicioCrearEspacio(repositorioEspacio);
    }

    @Bean
    public ServicioPagarOcupacion servicioPagarOcupacion(RepositorioOcupacion repositorioOcupacion, RepositorioEspacio repositorioEspacio, RepositorioFestivo repositorioFestivo) {
        return new ServicioPagarOcupacion(repositorioOcupacion, repositorioEspacio, repositorioFestivo);
    }

    @Bean
    public ServicioEliminarEspacio servicioEliminarEspacio(RepositorioEspacio repositorioEspacio, RepositorioOcupacion repositorioOcupacion) {
        return new ServicioEliminarEspacio(repositorioEspacio, repositorioOcupacion);
    }

    @Bean
    public ServicioActualizarEspacio servicioActualizarEspacio(RepositorioEspacio repositorioEspacio) {
        return new ServicioActualizarEspacio(repositorioEspacio);
    }

}

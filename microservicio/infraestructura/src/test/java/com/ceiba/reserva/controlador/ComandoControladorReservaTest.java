package com.ceiba.reserva.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.conductor.comando.ComandoConductor;
import com.ceiba.conductor.servicio.testdatabuilder.ComandoConductorTestDataBuilder;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.servicio.testdatabuilder.ComandoEspacioTestDataBuilder;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaTestDataBuilder;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.ComandoVehiculoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorReserva.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorReservaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception {
        ComandoReserva reserva = getComandoReserva();

        mocMvc.perform(post("/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        mocMvc.perform(post("/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void crearReservaSabado() throws Exception {
        ComandoReserva reserva = getComandoReserva();
        reserva.setFechaInicio(LocalDateTime.of(2021, 04, 24, 0, 0, 0));

        mocMvc.perform(post("/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void crearReservaDiasDiferentes() throws Exception {
        ComandoReserva reserva = getComandoReserva();
        reserva.setFechaInicio(LocalDateTime.of(2021, 04, 24, 0, 0, 0));
        reserva.setFechaFin(LocalDateTime.of(2021, 04, 28, 0, 0, 0));

        mocMvc.perform(post("/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    private ComandoReserva getComandoReserva() throws Exception {
        Long idVehiculo = 1L;
        ComandoVehiculo vehiculo = new ComandoVehiculoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/vehiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        Long idConductor = 1L;

        ComandoConductor conductor = new ComandoConductorTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/conductores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(conductor)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        Long idEspacio = 1L;

        ComandoEspacio espacio = new ComandoEspacioTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/espacio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(espacio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        ComandoReserva reserva = new ComandoReservaTestDataBuilder().conIdVehiculo(idVehiculo).conIdConductor(idConductor).conIdEspacio(idEspacio).build();
        return reserva;
    }


}

package com.ceiba.conductor.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.conductor.comando.ComandoConductor;
import com.ceiba.conductor.servicio.testdatabuilder.ComandoConductorTestDataBuilder;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.ComandoVehiculoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorConductor.class)
public class ConsultaControladorConductorTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        mocMvc.perform(get("/conductores")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void crearListar() throws Exception {
        ComandoConductor conductor = new ComandoConductorTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/conductores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(conductor)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        mocMvc.perform(get("/conductores")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}

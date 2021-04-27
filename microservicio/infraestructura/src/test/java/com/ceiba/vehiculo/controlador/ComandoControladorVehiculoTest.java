package com.ceiba.vehiculo.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tipoVehiculo.modelo.enumerado.TipoVehiculo;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorVehiculo.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorVehiculoTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void noDeberiaCrearDosVehiculoIgualPlaca() throws Exception {

        // arrange
        ComandoVehiculo vehiculo = new ComandoVehiculoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/vehiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        mocMvc.perform(post("/vehiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));

    }


}

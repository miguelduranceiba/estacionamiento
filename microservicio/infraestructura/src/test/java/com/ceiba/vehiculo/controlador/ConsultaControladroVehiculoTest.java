package com.ceiba.vehiculo.controlador;

import com.ceiba.ApplicationMock;
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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorVehiculo.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladroVehiculoTest {

    private static final String PLACA_MIG001 = "MIG001";
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        // act - assert

        mocMvc.perform(get("/vehiculos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void buscarVehiculoPorPlaca() throws Exception {

        ComandoVehiculo vehiculo = new ComandoVehiculoTestDataBuilder().conPlaca(PLACA_MIG001).build();

        mocMvc.perform(post("/vehiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        mocMvc.perform(get("/vehiculos/{placa}", PLACA_MIG001)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void listarPorPlacaNoEncontrada() throws Exception {
        mocMvc.perform(get("/vehiculos/{placa}", PLACA_MIG001)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
    }

}

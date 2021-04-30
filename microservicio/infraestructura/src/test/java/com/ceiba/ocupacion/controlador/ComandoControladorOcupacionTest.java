package com.ceiba.ocupacion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.ocupacion.comando.ComandoOcupacion;
import com.ceiba.ocupacion.servicio.testdatabuilder.ComandoOcupacionTestDataBuilder;
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

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorOcupacion.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorOcupacionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception {
        ComandoOcupacion ocupacion = new ComandoOcupacionTestDataBuilder().build();

        mocMvc.perform(post("/ocupacion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ocupacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        mocMvc.perform(post("/ocupacion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ocupacion)))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void pagar() throws Exception {
        LocalDateTime fechaInicio = LocalDateTime.now().minusHours(3);
        LocalDateTime fechaFin = LocalDateTime.now();
        Duration duration = Duration.between(fechaInicio, fechaFin);
        BigDecimal cantidadHoras = new BigDecimal(duration.toHours());
        BigDecimal total = new BigDecimal(5000).multiply(cantidadHoras);

        ComandoOcupacion ocupacion = new ComandoOcupacionTestDataBuilder().build();
        ocupacion.setFechaInicio(fechaInicio);

        mocMvc.perform(post("/ocupacion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ocupacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        mocMvc.perform(post("/ocupacion/pagar/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ocupacion)))
                .andExpect(status().isOk());

        mocMvc.perform(get("/ocupacion")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].total", is(total.doubleValue())));
    }


}

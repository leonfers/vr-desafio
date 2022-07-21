package com.vrbeneficio.autorizador;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.request.CartaoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CartoesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarUmCartaoERetornar() throws Exception {
        CartaoRequest cartao = new CartaoRequest("6549873025634501", "1234");
        mockMvc.perform(post("/cartoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartao)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numeroCartao", is("6549873025634501")))
                .andExpect(jsonPath("$.senha", is("1234")));
    }
}

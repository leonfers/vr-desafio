package com.vrbeneficio.autorizador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("staging")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CartoesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarUmCartao() throws Exception {
        CartaoDTO cartao = new CartaoDTO("6549873025634501", "1234");
        mockMvc.perform(post("/cartoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartao)))
                .andExpect(status().isCreated());
    }

    @Test
    void deveCriarUmNovoCartaoERetornar() throws Exception {
        CartaoDTO cartao = new CartaoDTO("172537d3713", "1643");
        mockMvc.perform(post("/cartoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartao)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numeroCartao", is("172537d3713")))
                .andExpect(jsonPath("$.senha", is("1643")));
    }

    @Test
    void deveTentarCriarUmNovoCartaoEDeveConstarQueJaExiste() throws Exception {
        CartaoDTO cartao = new CartaoDTO("17253737133", "16435");
        mockMvc.perform(post("/cartoes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartao)));
        mockMvc.perform(post("/cartoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartao)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.numeroCartao", is("17253737133")))
                .andExpect(jsonPath("$.senha", is("16435")));
    }

    @Test
    void deveTentarCriarUmNovoCartaoEDeveConsultarSeuSaldo() throws Exception {
        CartaoDTO cartao = new CartaoDTO("17253737133", "16435");
        mockMvc.perform(post("/cartoes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartao)));

        mockMvc.perform(get("/cartoes/"+cartao.getNumeroCartao()).contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("500.00"));
    }
}

package com.vrbeneficio.autorizador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vrbeneficio.autorizador.aplicacao.dominio.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Saldo;
import com.vrbeneficio.autorizador.aplicacao.persistencia.repositorio.CartaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("staging")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TransacaoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CartaoRepository cartaoRepository;

    @BeforeEach
    void criarCartao(){
        Cartao cartao = new Cartao();
        cartao.setNumeroCartao("6549873025634501");
        cartao.setSenha("1234");
        Saldo saldo = new Saldo();
        cartao.setSaldo(saldo);
        cartaoRepository.save(cartao);
    }

    @Test
    void deveCriarUmaTransacao() throws Exception {
        TransacaoDTO transacaoDTO = new TransacaoDTO("6549873025634501", "1234", new BigDecimal("10.00"));
        mockMvc.perform(post("/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacaoDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void deveFalharAoCriarUmaTransacaoComCartaoInexistente() throws Exception {
        TransacaoDTO transacaoDTO = new TransacaoDTO("654987302563501", "1234", new BigDecimal("10.00"));
        mockMvc.perform(post("/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacaoDTO)))
                .andExpect(content().string("CARTAO_INEXISTENTE"))
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    void deveFalharAoCriarUmaTransacaoComSaldoInsuficiente() throws Exception {
        TransacaoDTO transacaoDTO = new TransacaoDTO("6549873025634501", "1234", new BigDecimal("501.00"));
        mockMvc.perform(post("/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacaoDTO)))
                .andExpect(content().string("SALDO_INSUFICIENTE"))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void deveFalharAoCriarUmaTransacaoComSenhaInvalida() throws Exception {
        TransacaoDTO transacaoDTO = new TransacaoDTO("6549873025634501", "1231", new BigDecimal("500.00"));
        mockMvc.perform(post("/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacaoDTO)))
                .andExpect(content().string("SENHA_INVALIDA"))
                .andExpect(status().isUnprocessableEntity());
    }


    @Test
    void deveCriarUmaTransacaoEretornarSaldode450() throws Exception {
        TransacaoDTO transacaoDTO = new TransacaoDTO("6549873025634501", "1234", new BigDecimal("50.00"));
        mockMvc.perform(post("/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacaoDTO)))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/cartoes/"+transacaoDTO.getNumeroCartao()).contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("450.00"));
    }
}


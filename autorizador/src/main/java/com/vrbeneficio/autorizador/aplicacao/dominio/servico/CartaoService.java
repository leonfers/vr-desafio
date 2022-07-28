package com.vrbeneficio.autorizador.aplicacao.dominio.servico;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.CartaoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface CartaoService {

    CartaoDTO criarCartao(CartaoDTO cartaoDTO);

    BigDecimal consultarSaldo(String numeroCartao);
}

package com.vrbeneficio.autorizador.domain.service;

import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface CartaoService {

    CartaoDTO criarCartao(CartaoDTO cartaoDTO);

    BigDecimal consultarSaldo(String numeroCartao);
}

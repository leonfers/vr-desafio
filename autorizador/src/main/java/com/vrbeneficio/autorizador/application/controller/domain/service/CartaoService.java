package com.vrbeneficio.autorizador.application.controller.domain.service;

import com.vrbeneficio.autorizador.application.controller.domain.dto.CartaoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface CartaoService {

    CartaoDTO criarCartao(CartaoDTO cartaoDTO);

    BigDecimal consultarSaldo();
}

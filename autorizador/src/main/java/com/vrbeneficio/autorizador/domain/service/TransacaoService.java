package com.vrbeneficio.autorizador.domain.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface TransacaoService {
    void subtrairSaldo(BigDecimal valor, String numeroCartao, String senhaCartao);

    void verificarTransacao(BigDecimal valor, String numeroCartao, String senhaCartao);
}

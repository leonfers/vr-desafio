package com.vrbeneficio.autorizador.domain.service;

import com.vrbeneficio.autorizador.domain.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface TransacaoService {
    void subtrairSaldo(TransacaoDTO transacaoDTO);
}

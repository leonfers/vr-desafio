package com.vrbeneficio.autorizador.aplicacao.dominio.servico;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransacaoService {
    void subtrairSaldo(TransacaoDTO transacaoDTO);
}

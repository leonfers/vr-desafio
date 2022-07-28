package com.vrbeneficio.autorizador.domain.validator;

import com.vrbeneficio.autorizador.domain.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.exception.TransacaoInvalidaSenhaInvalidaException;

public class RegraTransacaoInvalidaSenhaInvalidaException implements Regra<Cartao, TransacaoDTO>{

    @Override
    public boolean validar(Cartao cartao, TransacaoDTO transacaoDTO) {
        return cartao!= null && !cartao.getSenha().equals(transacaoDTO.getSenhaCartao());
    }

    @Override
    public void error() {
        throw new TransacaoInvalidaSenhaInvalidaException();
    }
}

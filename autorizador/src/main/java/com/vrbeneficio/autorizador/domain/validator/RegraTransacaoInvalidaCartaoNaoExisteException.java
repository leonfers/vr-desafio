package com.vrbeneficio.autorizador.domain.validator;

import com.vrbeneficio.autorizador.domain.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.exception.TransacaoInvalidaCartaoNaoExisteException;

public class RegraTransacaoInvalidaCartaoNaoExisteException implements Regra<Cartao, TransacaoDTO>{

    @Override
    public boolean validar(Cartao cartao, TransacaoDTO transacaoDTO) {
        return cartao == null;
    }

    @Override
    public void error() {
        throw new TransacaoInvalidaCartaoNaoExisteException();
    }


}

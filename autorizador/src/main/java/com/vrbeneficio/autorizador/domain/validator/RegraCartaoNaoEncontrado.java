package com.vrbeneficio.autorizador.domain.validator;

import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.domain.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.exception.CartaoNaoEncontradoException;

public class RegraCartaoNaoEncontrado implements Regra<Cartao, String>{

    @Override
    public boolean validar(Cartao cartao, String numeroCartao) {
        return cartao == null;
    }

    @Override
    public void error() {
        throw new CartaoNaoEncontradoException();
    }


}

package com.vrbeneficio.autorizador.domain.validator;

import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.exception.CartaoJaExisteException;

public class RegraCartaoJaExisteException  implements Regra<Cartao, CartaoDTO>{

    CartaoDTO cartao;

    @Override
    public boolean validar(Cartao cartao, CartaoDTO comparavel) {
        this.cartao = comparavel;
        return cartao != null;
    }

    @Override
    public void error() {
        throw new CartaoJaExisteException(this.cartao);
    }
}

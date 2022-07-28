package com.vrbeneficio.autorizador.aplicacao.dominio.validacao;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.CartaoDTO;
import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.CartaoJaExisteException;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;

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

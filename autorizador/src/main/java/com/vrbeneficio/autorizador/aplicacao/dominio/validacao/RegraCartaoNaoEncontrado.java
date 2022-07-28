package com.vrbeneficio.autorizador.aplicacao.dominio.validacao;

import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;
import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.CartaoNaoEncontradoException;

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

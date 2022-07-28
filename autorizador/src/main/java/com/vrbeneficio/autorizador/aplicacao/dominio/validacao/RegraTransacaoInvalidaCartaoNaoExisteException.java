package com.vrbeneficio.autorizador.aplicacao.dominio.validacao;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.TransacaoInvalidaCartaoNaoExisteException;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;

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

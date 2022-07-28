package com.vrbeneficio.autorizador.aplicacao.dominio.validacao;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;
import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.TransacaoInvalidaSenhaInvalidaException;

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

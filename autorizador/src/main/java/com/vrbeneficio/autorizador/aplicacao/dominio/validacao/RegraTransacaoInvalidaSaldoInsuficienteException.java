package com.vrbeneficio.autorizador.aplicacao.dominio.validacao;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;
import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.TransacaoInvalidaSaldoInsuficienteException;

public class RegraTransacaoInvalidaSaldoInsuficienteException implements Regra<Cartao, TransacaoDTO>{

    @Override
    public boolean validar(Cartao cartao, TransacaoDTO transacaoDTO) {
        return cartao!= null && !cartao.getSaldo().possuiValor(transacaoDTO.getValor());
    }

    @Override
    public void error() {
        throw new TransacaoInvalidaSaldoInsuficienteException();
    }
}

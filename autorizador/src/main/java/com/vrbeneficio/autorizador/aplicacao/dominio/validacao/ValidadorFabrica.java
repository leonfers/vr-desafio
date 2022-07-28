package com.vrbeneficio.autorizador.aplicacao.dominio.validacao;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.CartaoDTO;
import com.vrbeneficio.autorizador.aplicacao.dominio.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;

public class ValidadorFabrica {

    public Validador<Cartao, TransacaoDTO> validadorTransacao(){
        Validador<Cartao, TransacaoDTO> validador = new Validador();
        validador.adicionarRegra(new RegraTransacaoInvalidaCartaoNaoExisteException());
        validador.adicionarRegra(new RegraTransacaoInvalidaSaldoInsuficienteException());
        validador.adicionarRegra(new RegraTransacaoInvalidaSenhaInvalidaException());
        return validador;
    }

    public Validador<Cartao, CartaoDTO> validadorNovoCartao(){
        Validador<Cartao, CartaoDTO> validador = new Validador();
        validador.adicionarRegra(new RegraCartaoJaExisteException());
        return validador;
    }

    public Validador<Cartao, String> validadorSaldoCartao(){
        Validador<Cartao, String> validador = new Validador();
        validador.adicionarRegra(new RegraCartaoNaoEncontrado());
        return validador;
    }


}

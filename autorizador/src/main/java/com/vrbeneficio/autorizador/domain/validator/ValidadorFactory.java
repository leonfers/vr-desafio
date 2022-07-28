package com.vrbeneficio.autorizador.domain.validator;

import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.domain.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;

public class ValidadorFactory {

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

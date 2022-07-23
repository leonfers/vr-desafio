package com.vrbeneficio.autorizador.domain.service;

import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.entity.Saldo;
import com.vrbeneficio.autorizador.domain.exception.TransacaoInvalidaCartaoNaoExisteException;
import com.vrbeneficio.autorizador.domain.exception.TransacaoInvalidaSaldoInsuficienteException;
import com.vrbeneficio.autorizador.domain.exception.TransacaoInvalidaSenhaInvalidaException;
import com.vrbeneficio.autorizador.domain.repository.CartaoRepository;
import com.vrbeneficio.autorizador.domain.repository.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransacaoServiceBean implements TransacaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private SaldoRepository saldoRepository;


    @Override
    @Transactional
    public void subtrairSaldo(BigDecimal valor, String numeroCartao, String senhaCartao) {
        verificarTransacao(valor, numeroCartao, senhaCartao);
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(numeroCartao);
        Cartao cartao = cartaoOptional.get();
        cartao.getSaldo().subtrairValor(valor);
        cartaoRepository.save(cartao);
    }

    @Override
    @Transactional
    public void verificarTransacao(BigDecimal valor, String numeroCartao, String senhaCartao) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(numeroCartao);
        if(cartaoOptional.isPresent()){
            Cartao cartao = cartaoOptional.get();
            if(!cartao.getSenha().equals(senhaCartao)){
                throw new TransacaoInvalidaSenhaInvalidaException();
            }
            if(!cartao.getSaldo().possuiValor(valor)){
                throw new TransacaoInvalidaSaldoInsuficienteException();
            }
        } else {
            throw new TransacaoInvalidaCartaoNaoExisteException();
        }
    }


    public CartaoRepository getCartaoRepository() {
        return cartaoRepository;
    }

    public void setCartaoRepository(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }


}

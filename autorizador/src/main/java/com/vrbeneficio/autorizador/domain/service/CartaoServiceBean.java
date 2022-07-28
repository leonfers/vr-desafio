package com.vrbeneficio.autorizador.domain.service;

import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.entity.Saldo;
import com.vrbeneficio.autorizador.domain.exception.CartaoJaExisteException;
import com.vrbeneficio.autorizador.domain.exception.CartaoNaoEncontradoException;
import com.vrbeneficio.autorizador.domain.repository.CartaoRepository;
import com.vrbeneficio.autorizador.domain.validator.ValidadorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class CartaoServiceBean implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    @Transactional
    public CartaoDTO criarCartao(CartaoDTO cartaoDTO) {
        Cartao cartaoSalvo = cartaoRepository.findById(cartaoDTO.getNumeroCartao()).orElse(null);
        new ValidadorFactory().validadorNovoCartao().validarRegras(cartaoSalvo, cartaoDTO);
        Cartao cartao= new Cartao();
        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setSenha(cartaoDTO.getSenha());
        Saldo saldo = new Saldo();
        cartao.setSaldo(saldo);
        cartaoRepository.save(cartao);
        return new CartaoDTO(cartao);
    }

    @Override
    public BigDecimal consultarSaldo(String numeroCartao) {
        Cartao cartao = cartaoRepository.findById(numeroCartao).orElse(null);
        new ValidadorFactory().validadorSaldoCartao().validarRegras(cartao, numeroCartao);
        return cartao.getSaldo().getValor();
    }
}

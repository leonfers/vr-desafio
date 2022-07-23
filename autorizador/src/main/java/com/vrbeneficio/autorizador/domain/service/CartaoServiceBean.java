package com.vrbeneficio.autorizador.domain.service;

import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.entity.Saldo;
import com.vrbeneficio.autorizador.domain.exception.CartaoJaExisteException;
import com.vrbeneficio.autorizador.domain.exception.CartaoNaoEncontradoException;
import com.vrbeneficio.autorizador.domain.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CartaoServiceBean implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    @Transactional
    public CartaoDTO criarCartao(CartaoDTO cartaoDTO) {
        this.validarCartao(cartaoDTO);
        Cartao cartao= new Cartao();
        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setSenha(cartaoDTO.getSenha());
        Saldo saldo = new Saldo();
        cartao.setSaldo(saldo);
        cartaoRepository.save(cartao);
        return new CartaoDTO(cartao);
    }

    public void validarCartao(CartaoDTO cartaoDTO){
        Optional<Cartao> cartao = cartaoRepository.findById(cartaoDTO.getNumeroCartao());
        if(cartao.isPresent()){
            throw new CartaoJaExisteException(cartaoDTO);
        }
    }

    @Override
    public BigDecimal consultarSaldo(String numeroCartao) {
        Optional<Cartao> cartao = cartaoRepository.findById(numeroCartao);
        return cartao.orElseThrow(CartaoNaoEncontradoException::new).getSaldo().getValor();
    }
}

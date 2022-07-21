package com.vrbeneficio.autorizador.application.controller.domain.service;

import com.vrbeneficio.autorizador.application.controller.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.application.controller.domain.entity.Cartao;
import com.vrbeneficio.autorizador.application.controller.domain.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartaoServiceBean implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public CartaoDTO criarCartao(CartaoDTO cartaoDTO) {
        Cartao cartao= new Cartao();
        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setSenha(cartaoDTO.getSenha());
        cartaoRepository.save(cartao);
        return new CartaoDTO(cartao);
    }

    @Override
    public BigDecimal consultarSaldo() {
        return null;
    }
}

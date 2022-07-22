package com.vrbeneficio.autorizador.domain.service;

import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.exception.CartaoJaExisteException;
import com.vrbeneficio.autorizador.domain.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CartaoServiceBean implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public CartaoDTO criarCartao(CartaoDTO cartaoDTO) {
        this.validarCartao(cartaoDTO);
        Cartao cartao= new Cartao();
        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setSenha(cartaoDTO.getSenha());
        cartao.setSaldo(new BigDecimal(500));
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
    public BigDecimal consultarSaldo() {
        return null;
    }
}

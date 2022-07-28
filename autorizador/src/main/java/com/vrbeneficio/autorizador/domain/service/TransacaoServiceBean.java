package com.vrbeneficio.autorizador.domain.service;

import com.vrbeneficio.autorizador.domain.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.domain.entity.Cartao;
import com.vrbeneficio.autorizador.domain.repository.CartaoRepository;
import com.vrbeneficio.autorizador.domain.validator.ValidadorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TransacaoServiceBean implements TransacaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    @Transactional
    public void subtrairSaldo(TransacaoDTO transacaoDTO) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(transacaoDTO.getNumeroCartao());
        Cartao cartao = cartaoOptional.orElse(null);
        new ValidadorFactory().validadorTransacao().validarRegras(cartao, transacaoDTO);
        cartao.getSaldo().subtrairValor(transacaoDTO.getValor());
        cartaoRepository.save(cartao);
    }

    public CartaoRepository getCartaoRepository() {
        return cartaoRepository;
    }

    public void setCartaoRepository(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }


}

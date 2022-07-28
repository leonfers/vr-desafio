package com.vrbeneficio.autorizador.aplicacao.dominio.servico;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.CartaoDTO;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Saldo;
import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;
import com.vrbeneficio.autorizador.aplicacao.persistencia.repositorio.CartaoRepository;
import com.vrbeneficio.autorizador.aplicacao.dominio.validacao.ValidadorFabrica;
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
        new ValidadorFabrica().validadorNovoCartao().validarRegras(cartaoSalvo, cartaoDTO);
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
        new ValidadorFabrica().validadorSaldoCartao().validarRegras(cartao, numeroCartao);
        return cartao.getSaldo().getValor();
    }
}

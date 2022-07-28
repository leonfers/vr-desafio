package com.vrbeneficio.autorizador.aplicacao.dominio.dto;

import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;
import lombok.Data;

import java.io.Serializable;

@Data
public class CartaoDTO implements Serializable {

    private String numeroCartao;
    private String senha;

    public CartaoDTO() {
    }

    public CartaoDTO(String numeroCartao, String senha) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
    }

    public CartaoDTO(Cartao cartao) {
        this.numeroCartao = cartao.getNumeroCartao();
        this.senha = cartao.getSenha();
    }
}
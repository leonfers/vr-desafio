package com.vrbeneficio.autorizador.application.controller.domain.dto;

import com.vrbeneficio.autorizador.application.controller.domain.entity.Cartao;
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
        this.numeroCartao = getNumeroCartao();
        this.senha = getSenha();
    }
}
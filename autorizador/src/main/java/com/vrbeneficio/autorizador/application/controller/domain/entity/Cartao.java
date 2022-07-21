package com.vrbeneficio.autorizador.application.controller.domain.entity;

import com.sun.xml.bind.v2.TODO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
    @Id
    @Column(name = "numeroCartao", nullable = false)
    private String numeroCartao;

    @Column(name = "senha", nullable = false)
    private String senha; //TODO Persistir a senha criptografada

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

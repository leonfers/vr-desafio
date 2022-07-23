package com.vrbeneficio.autorizador.domain.entity;

import com.sun.xml.bind.v2.TODO;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Cartao {
    @Id
    @Column(name = "numeroCartao", nullable = false)
    private String numeroCartao;

    @Column(name = "senha", nullable = false)
    private String senha; //TODO Persistir a senha criptografada

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private Saldo saldo;

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

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }
}

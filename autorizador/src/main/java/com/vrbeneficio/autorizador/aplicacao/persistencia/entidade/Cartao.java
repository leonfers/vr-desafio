package com.vrbeneficio.autorizador.aplicacao.persistencia.entidade;

import javax.persistence.*;

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

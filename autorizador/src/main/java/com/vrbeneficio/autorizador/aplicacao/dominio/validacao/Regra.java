package com.vrbeneficio.autorizador.aplicacao.dominio.validacao;

public interface Regra<T, U> {
    boolean validar(T objeto, U comparavel);

    void error();
}

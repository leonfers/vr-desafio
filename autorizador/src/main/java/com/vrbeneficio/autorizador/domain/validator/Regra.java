package com.vrbeneficio.autorizador.domain.validator;

public interface Regra<T, U> {
    boolean validar(T objeto, U comparavel);

    void error();
}

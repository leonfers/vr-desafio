package com.vrbeneficio.autorizador.domain.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Validador<T, U> {

    private final List<Regra<T,U>> regras = new ArrayList<>();

    public void validarRegras(T objeto,  U comparavel) {
        List<Regra<T,U>> resultados = regras
                .stream()
                .filter(r -> r.validar(objeto, comparavel))
                .collect(Collectors.toList());
        resultados.forEach(Regra::error);
    }

    public void adicionarRegra(Regra<T,U> regra){
        this.regras.add(regra);
    }


}

package com.vrbeneficio.autorizador.aplicacao.controller;

import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.CartaoJaExisteException;
import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.CartaoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartaoExceptionController {

    @ExceptionHandler(value = CartaoJaExisteException.class)
    public ResponseEntity<Object> exception(CartaoJaExisteException exception) {
        return new ResponseEntity<>(exception.getCartaoDTO(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = CartaoNaoEncontradoException.class)
    public ResponseEntity<Object> exception() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

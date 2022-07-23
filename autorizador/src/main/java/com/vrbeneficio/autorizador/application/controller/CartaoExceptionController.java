package com.vrbeneficio.autorizador.application.controller;

import com.vrbeneficio.autorizador.domain.exception.CartaoJaExisteException;
import com.vrbeneficio.autorizador.domain.exception.CartaoNaoEncontradoException;
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

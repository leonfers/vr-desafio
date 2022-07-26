package com.vrbeneficio.autorizador.aplicacao.controller;

import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.TransacaoInvalidaCartaoNaoExisteException;
import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.TransacaoInvalidaSaldoInsuficienteException;
import com.vrbeneficio.autorizador.aplicacao.dominio.excecao.TransacaoInvalidaSenhaInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransacaoExceptionController {

    @ExceptionHandler(value = TransacaoInvalidaCartaoNaoExisteException.class)
    public ResponseEntity<Object> exception(TransacaoInvalidaCartaoNaoExisteException exception) {
        return new ResponseEntity<>("CARTAO_INEXISTENTE", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = TransacaoInvalidaSaldoInsuficienteException.class)
    public ResponseEntity<Object> exception(TransacaoInvalidaSaldoInsuficienteException exception) {
        return new ResponseEntity<>("SALDO_INSUFICIENTE", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = TransacaoInvalidaSenhaInvalidaException.class)
    public ResponseEntity<Object> exception(TransacaoInvalidaSenhaInvalidaException exception) {
        return new ResponseEntity<>("SENHA_INVALIDA", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

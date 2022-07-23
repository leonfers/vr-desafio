package com.vrbeneficio.autorizador.application.controller;

import com.sun.istack.NotNull;
import com.vrbeneficio.autorizador.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.domain.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.domain.service.CartaoService;
import com.vrbeneficio.autorizador.domain.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/")
public class TransacoesController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacoes")
    public ResponseEntity<String> criarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        transacaoService.subtrairSaldo(transacaoDTO.getValor(), transacaoDTO.getNumeroCartao(), transacaoDTO.getSenhaCartao());
        return new ResponseEntity<>("OK",HttpStatus.CREATED);
    }

    public TransacaoService getTransacaoService() {
        return transacaoService;
    }

    public void setTransacaoService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }
}

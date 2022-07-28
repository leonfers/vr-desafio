package com.vrbeneficio.autorizador.aplicacao.controller;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.TransacaoDTO;
import com.vrbeneficio.autorizador.aplicacao.dominio.servico.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TransacoesController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacoes")
    public ResponseEntity<String> criarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        transacaoService.subtrairSaldo(transacaoDTO);
        return new ResponseEntity<>("OK",HttpStatus.CREATED);
    }

    public TransacaoService getTransacaoService() {
        return transacaoService;
    }

    public void setTransacaoService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }
}

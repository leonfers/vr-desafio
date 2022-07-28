package com.vrbeneficio.autorizador.aplicacao.controller;

import com.sun.istack.NotNull;
import com.vrbeneficio.autorizador.aplicacao.dominio.dto.CartaoDTO;
import com.vrbeneficio.autorizador.aplicacao.dominio.servico.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/")
public class CartoesController {

    private CartaoService cartaoService;

    @PostMapping("/cartoes")
    public ResponseEntity<CartaoDTO> getCartao(@RequestBody CartaoDTO cartaoDTO) {
        CartaoDTO cartao = cartaoService.criarCartao(cartaoDTO);
        return new ResponseEntity<>(cartao, HttpStatus.CREATED);
    }

    @GetMapping("/cartoes/{numeroCartao}")
    public ResponseEntity<BigDecimal> getCartao(@PathVariable @NotNull String numeroCartao) {
        BigDecimal saldo = cartaoService.consultarSaldo(numeroCartao);
        return new ResponseEntity<>(saldo, HttpStatus.OK);
    }

    public CartaoService getCartaoService() {
        return cartaoService;
    }

    @Autowired
    public void setCartaoService(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }
}

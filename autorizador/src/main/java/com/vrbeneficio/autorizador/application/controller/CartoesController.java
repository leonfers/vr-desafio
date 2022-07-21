package com.vrbeneficio.autorizador.application.controller;

import com.vrbeneficio.autorizador.application.controller.domain.dto.CartaoDTO;
import com.vrbeneficio.autorizador.application.controller.domain.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CartoesController {

    private CartaoService cartaoService;

    @PostMapping("/cartoes")
    public ResponseEntity<CartaoDTO> getCartao(@RequestBody CartaoDTO cartaoDTO) {
        CartaoDTO cartao= cartaoService.criarCartao(cartaoDTO);
        return new ResponseEntity<>(cartao, HttpStatus.CREATED);
    }

    public CartaoService getCartaoService() {
        return cartaoService;
    }

    @Autowired
    public void setCartaoService(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }
}

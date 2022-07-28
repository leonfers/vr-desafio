package com.vrbeneficio.autorizador.aplicacao.dominio.excecao;

import com.vrbeneficio.autorizador.aplicacao.dominio.dto.CartaoDTO;

public class CartaoJaExisteException extends IllegalArgumentException {
    CartaoDTO cartaoDTO;

    public CartaoJaExisteException(CartaoDTO cartaoDTO){
        this.cartaoDTO = cartaoDTO;
    }

    public CartaoDTO getCartaoDTO() {
        return cartaoDTO;
    }

    public void setCartaoDTO(CartaoDTO cartaoDTO) {
        this.cartaoDTO = cartaoDTO;
    }
}

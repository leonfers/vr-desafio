package application.controller;

import domain.request.CartaoRequest;
import domain.response.CartaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CartoesController {

    @PostMapping("/cartoes")
    public ResponseEntity<CartaoResponse> getCartao(@RequestBody CartaoRequest cartaoRequest) {
        System.out.println(cartaoRequest);
        CartaoResponse cartaoResponse = new CartaoResponse();
        cartaoResponse.setNumeroCartao(cartaoRequest.getNumeroCartao());
        cartaoResponse.setSenha(cartaoRequest.getSenha());
        return new ResponseEntity<>(cartaoResponse, HttpStatus.CREATED);
    }
}

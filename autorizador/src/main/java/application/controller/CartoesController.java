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
    public @ResponseBody ResponseEntity<CartaoResponse> getCartao(CartaoRequest cartaoRequest) {
        CartaoResponse cartaoResponse = new CartaoResponse();
        cartaoResponse.setNumeroCartao("6549873025634501");
        cartaoResponse.setSenha("1234");
        return new ResponseEntity<>(cartaoResponse, HttpStatus.CREATED);
    }
}

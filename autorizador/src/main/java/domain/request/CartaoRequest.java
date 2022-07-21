package domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartaoRequest implements Serializable {

    private String numeroCartao;
    private String senha;

    public CartaoRequest(String numeroCartao, String senha) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
    }
}
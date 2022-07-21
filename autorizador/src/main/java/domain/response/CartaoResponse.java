package domain.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartaoResponse implements Serializable {

    private String numeroCartao;
    private String senha;

}

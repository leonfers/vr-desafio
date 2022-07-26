package com.vrbeneficio.autorizador.dominio.entidade;

import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Saldo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("staging")
class SaldoTest {

    @Test
    void saldoDeveSerIgualA500(){
        Saldo saldo = new Saldo();
        assertEquals(new BigDecimal(500), saldo.getValor());
    }

    @Test
    void saldoDeveSerSomado500IgualA1000(){
        Saldo saldo = new Saldo();
        saldo.adicionarValor(new BigDecimal(500));
        assertEquals(new BigDecimal(1000), saldo.getValor());
    }

    @Test
    void saldoDeveSerSubitraido250IgualA250(){
        Saldo saldo = new Saldo();
        saldo.subtrairValor(new BigDecimal(250));
        assertEquals(new BigDecimal(250), saldo.getValor());
    }

    @Test
    void saldoDevePossuirOValor(){
        Saldo saldo = new Saldo();
        assertTrue(saldo.possuiValor(new BigDecimal(500)));
    }

    @Test
    void saldoNaoDevePossuirOValor(){
        Saldo saldo = new Saldo();
        assertFalse(saldo.possuiValor(new BigDecimal(501)));
    }

}
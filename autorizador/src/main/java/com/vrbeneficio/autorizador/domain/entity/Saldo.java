package com.vrbeneficio.autorizador.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.vrbeneficio.autorizador.domain.constants.SaldoConstant.SALDO_INICIAL;

@Entity
public class Saldo {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal valor = SALDO_INICIAL;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal value) {
        this.valor = value;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public BigDecimal adicionarValor(BigDecimal valor){
        this.valor = this.valor.add(valor);
        return this.valor;
    }

    public BigDecimal subtrairValor(BigDecimal valor){
        this.valor = this.valor.subtract(valor);
        return this.valor;
    }
}

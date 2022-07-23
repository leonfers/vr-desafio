package com.vrbeneficio.autorizador.domain.repository;

import com.vrbeneficio.autorizador.domain.entity.Saldo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoRepository extends CrudRepository<Saldo, String> {


}

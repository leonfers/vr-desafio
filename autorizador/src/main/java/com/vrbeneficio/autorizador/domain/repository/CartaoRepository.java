package com.vrbeneficio.autorizador.domain.repository;

import com.vrbeneficio.autorizador.domain.entity.Cartao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, String> {


}

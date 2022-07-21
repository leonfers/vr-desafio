package com.vrbeneficio.autorizador.application.controller.domain.repository;

import com.vrbeneficio.autorizador.application.controller.domain.entity.Cartao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long> {


}

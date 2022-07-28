package com.vrbeneficio.autorizador.aplicacao.persistencia.repositorio;

import com.vrbeneficio.autorizador.aplicacao.persistencia.entidade.Cartao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, String> {


}

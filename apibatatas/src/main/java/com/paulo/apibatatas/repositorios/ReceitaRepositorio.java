package com.paulo.apibatatas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paulo.apibatatas.modelos.Receita;

@Repository
public interface ReceitaRepositorio extends CrudRepository<Receita, Long> {
	Receita findById(long id);
}

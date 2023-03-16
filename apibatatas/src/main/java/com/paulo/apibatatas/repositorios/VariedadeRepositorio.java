package com.paulo.apibatatas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paulo.apibatatas.modelos.Variedade;

@Repository
public interface VariedadeRepositorio extends CrudRepository<Variedade, Long> {
	Variedade findById(long id);
}

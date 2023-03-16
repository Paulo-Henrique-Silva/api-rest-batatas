package com.paulo.apibatatas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paulo.apibatatas.modelos.Local;

@Repository
public interface LocalRepositorio extends CrudRepository<Local, Long> {
	Local findById(long id);
}

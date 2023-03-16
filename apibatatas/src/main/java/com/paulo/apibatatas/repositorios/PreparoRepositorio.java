package com.paulo.apibatatas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paulo.apibatatas.modelos.Preparo;

@Repository
public interface PreparoRepositorio extends CrudRepository<Preparo, Long> {

}

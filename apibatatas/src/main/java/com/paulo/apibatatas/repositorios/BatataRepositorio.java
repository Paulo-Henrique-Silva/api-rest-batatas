package com.paulo.apibatatas.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paulo.apibatatas.modelos.Batata;

@Repository
public interface BatataRepositorio extends CrudRepository<Batata, Long> {
	
	/**
	 * Seleciona todos os registros de batatas.
	 */
	List<Batata> findAll();
	
	/**
	 * Seleciona um registro específico de batata.
	 * @param id
	 * @return
	 */
	Batata findById(long id);
	
	/**
	 * Salva ou altera um registro de batata.
	 */
	<Bat extends Batata> Bat save(Bat batata);
	
	/**
	 * Deleta um registro de batata pelo id.
	 * @param id
	 */
	void deleteById(long id);
}

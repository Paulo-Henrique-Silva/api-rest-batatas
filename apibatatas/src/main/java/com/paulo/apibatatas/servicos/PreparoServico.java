package com.paulo.apibatatas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulo.apibatatas.modelos.Batata;
import com.paulo.apibatatas.modelos.Preparo;
import com.paulo.apibatatas.modelos.Receita;
import com.paulo.apibatatas.repositorios.BatataRepositorio;
import com.paulo.apibatatas.repositorios.PreparoRepositorio;
import com.paulo.apibatatas.repositorios.ReceitaRepositorio;

@Service
public class PreparoServico {
	
	@Autowired
	private PreparoRepositorio preparoRepositorio;
	
	@Autowired
	private BatataRepositorio batataRepositorio;
	
	@Autowired
	private ReceitaRepositorio receitaRepositorio;
	
	public ResponseEntity<?> verTodos() {
		return new ResponseEntity<>(preparoRepositorio.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> verPorId(long id) {
		
		//checa se existe o preparo especificado no parâmetro.
		if (!preparoRepositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe um preparo com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(preparoRepositorio.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<?> adicionar(Preparo preparo) {
		Batata batata = batataRepositorio.findById(preparo.getBatata().getId());
		Receita receita = receitaRepositorio.findById(preparo.getReceita().getId());
		
		preparo.setBatata(batata);
		preparo.setReceita(receita);
		
		return new ResponseEntity<>(preparoRepositorio.save(preparo), HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> alterar(Preparo preparo) {
		
		if (!preparoRepositorio.existsById(preparo.getId())) {
			return new ResponseEntity<>("Não existe um preparo com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(preparoRepositorio.save(preparo), HttpStatus.OK);
	}
	
	public ResponseEntity<?> deletarPorId(long id) {
		
		if (!preparoRepositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe um preparo com este id.", HttpStatus.BAD_REQUEST);
		}
		
		preparoRepositorio.deleteById(id);
		
		return new ResponseEntity<>("Preparo deletado com sucesso.", HttpStatus.OK);
	}
}

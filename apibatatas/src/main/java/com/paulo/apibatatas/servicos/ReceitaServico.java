package com.paulo.apibatatas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulo.apibatatas.modelos.Receita;
import com.paulo.apibatatas.repositorios.ReceitaRepositorio;

@Service
public class ReceitaServico {
	
	@Autowired
	private ReceitaRepositorio receitaRepositorio;
	
	public ResponseEntity<?> verTodas() {
		return new ResponseEntity<>(receitaRepositorio.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> verPorId(long id) {
		
		//checa se existe a receita especificada no parâmetro.
		if (!receitaRepositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe uma receita com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(receitaRepositorio.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<?> adicionar(Receita receita) {
		return new ResponseEntity<>(receitaRepositorio.save(receita), HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> alterar(Receita receita) {
		
		if (!receitaRepositorio.existsById(receita.getId())) {
			return new ResponseEntity<>("Não existe uma receita com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(receitaRepositorio.save(receita), HttpStatus.OK);
	}
	
	public ResponseEntity<?> deletarPorId(long id) {
		
		if (!receitaRepositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe uma receita com este id.", HttpStatus.BAD_REQUEST);
		}
		
		receitaRepositorio.deleteById(id);
		
		return new ResponseEntity<>("Receita deletada com sucesso.", HttpStatus.OK);
	}
	
}

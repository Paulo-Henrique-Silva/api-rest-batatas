package com.paulo.apibatatas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulo.apibatatas.modelos.Local;
import com.paulo.apibatatas.repositorios.LocalRepositorio;

@Service
public class LocalServico {
	
	@Autowired
	private LocalRepositorio localRepositorio;
	
	public ResponseEntity<?> verTodos() {
		return new ResponseEntity<>(localRepositorio.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> verPorId(long id) {
		
		//checa se existe o local especificado no parâmetro.
		if (!localRepositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe um local com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(localRepositorio.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<?> adicionar(Local local) {
		return new ResponseEntity<>(localRepositorio.save(local), HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> alterar(Local batata) {
		
		if (!localRepositorio.existsById(batata.getId())) {
			return new ResponseEntity<>("Não existe um local com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(localRepositorio.save(batata), HttpStatus.OK);
	}
	
	public ResponseEntity<?> deletarPorId(long id) {
		
		if (!localRepositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe um local com este id.", HttpStatus.BAD_REQUEST);
		}
		
		localRepositorio.deleteById(id);
		
		return new ResponseEntity<>("Local deletado com sucesso.", HttpStatus.OK);
	}
}

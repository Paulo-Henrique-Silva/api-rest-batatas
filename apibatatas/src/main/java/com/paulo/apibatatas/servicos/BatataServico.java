package com.paulo.apibatatas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulo.apibatatas.modelos.Batata;
import com.paulo.apibatatas.repositorios.BatataRepositorio;

@Service
public class BatataServico {
	
	@Autowired
	private BatataRepositorio repositorio;
	
	public ResponseEntity<?> verTodas() {
		return new ResponseEntity<>(repositorio.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> verPorId(long id) {
		
		//checa se existe a batata especificada no parâmetro.
		if (!repositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe uma batata com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(repositorio.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<?> adicionar(Batata batata) {
		return new ResponseEntity<>(repositorio.save(batata), HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> alterar(Batata batata) {
		
		if (!repositorio.existsById(batata.getId())) {
			return new ResponseEntity<>("Não existe uma batata com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(repositorio.save(batata), HttpStatus.OK);
	}
	
	public ResponseEntity<?> deletar(long id) {
		
		if (!repositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe uma batata com este id.", HttpStatus.BAD_REQUEST);
		}
		
		repositorio.deleteById(id);
		
		return new ResponseEntity<>("Batata deletada com sucesso.", HttpStatus.OK);
	}
	
}

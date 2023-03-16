package com.paulo.apibatatas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulo.apibatatas.modelos.Variedade;
import com.paulo.apibatatas.repositorios.VariedadeRepositorio;

@Service
public class VariedadeServico {
	
	@Autowired
	private VariedadeRepositorio variedadeRepositorio;
		
	public ResponseEntity<?> verTodas() {
		return new ResponseEntity<>(variedadeRepositorio.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> verPorId(long id) {
		
		//checa se existe a variedade especificada no parâmetro.
		if (!variedadeRepositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe uma variedade com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(variedadeRepositorio.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<?> adicionar(Variedade variedade) {
		return new ResponseEntity<>(variedadeRepositorio.save(variedade), HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> alterar(Variedade variedade) {
		
		if (!variedadeRepositorio.existsById(variedade.getId())) {
			return new ResponseEntity<>("Não existe uma variedade com este id.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(variedadeRepositorio.save(variedade), HttpStatus.OK);
	}
	
	public ResponseEntity<?> deletarPorId(long id) {
		
		if (!variedadeRepositorio.existsById(id)) {
			return new ResponseEntity<>("Não existe uma variedade com este id.", HttpStatus.BAD_REQUEST);
		}
		
		variedadeRepositorio.deleteById(id);
		
		return new ResponseEntity<>("Variedade deletada com sucesso.", HttpStatus.OK);
	}
}

package com.paulo.apibatatas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.apibatatas.modelos.Preparo;
import com.paulo.apibatatas.servicos.PreparoServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/preparos")
public class PreparoControlador {
	
	@Autowired
	private PreparoServico preparoServico;
	
	@GetMapping("")
	public ResponseEntity<?> verLocais() {
		return preparoServico.verTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verLocal(@PathVariable long id) {
		return preparoServico.verPorId(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> adicionarLocal(@Valid @RequestBody Preparo preparo) {
		return preparoServico.adicionar(preparo);
	}
	
	@PutMapping("")
	public ResponseEntity<?> alterarLocal(@Valid @RequestBody Preparo preparo) {
		return preparoServico.alterar(preparo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarLocal(@PathVariable long id) {
		return preparoServico.deletarPorId(id);
	}
}

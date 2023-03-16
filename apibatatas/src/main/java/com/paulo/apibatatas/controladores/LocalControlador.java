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

import com.paulo.apibatatas.modelos.Local;
import com.paulo.apibatatas.servicos.LocalServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/locais")
public class LocalControlador {
	
	@Autowired
	private LocalServico localServico;
	
	@GetMapping("")
	public ResponseEntity<?> verLocais() {
		return localServico.verTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verLocal(@PathVariable long id) {
		return localServico.verPorId(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> adicionarLocal(@Valid @RequestBody Local local) {
		return localServico.adicionar(local);
	}
	
	@PutMapping("")
	public ResponseEntity<?> alterarLocal(@Valid @RequestBody Local local) {
		return localServico.alterar(local);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarLocal(@PathVariable long id) {
		return localServico.deletarPorId(id);
	}
}

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

import com.paulo.apibatatas.modelos.Variedade;
import com.paulo.apibatatas.servicos.VariedadeServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/variedades")
public class VariedadeControlador {
	
	@Autowired
	private VariedadeServico variedadeServico;
	
	@GetMapping("")
	public ResponseEntity<?> verVariedades() {
		return variedadeServico.verTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verVariedade(@PathVariable long id) {
		return variedadeServico.verPorId(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> adicionarVariedade(@Valid @RequestBody Variedade variedade) {
		return variedadeServico.adicionar(variedade);
	}
	
	@PutMapping("")
	public ResponseEntity<?> alterarVariedade(@Valid @RequestBody Variedade variedade) {
		return variedadeServico.alterar(variedade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarVariedade(@PathVariable long id) {
		return variedadeServico.deletarPorId(id);
	}
}

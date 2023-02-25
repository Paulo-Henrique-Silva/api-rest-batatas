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

import com.paulo.apibatatas.modelos.Batata;
import com.paulo.apibatatas.servicos.BatataServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/batatas")
public class Controlador {
	
	@Autowired
	private BatataServico batataServico;
	
	@GetMapping("")
	public ResponseEntity<?> verBatatas() {
		return batataServico.verTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verBatata(@PathVariable long id) {
		return batataServico.verPorId(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> adicionarBatata(@Valid @RequestBody Batata batata) {
		return batataServico.adicionar(batata);
	}
	
	@PutMapping("")
	public ResponseEntity<?> alterarBatata(@Valid @RequestBody Batata batata) {
		return batataServico.alterar(batata);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarBatata(@PathVariable long id) {
		return batataServico.deletarPorId(id);
	}
}

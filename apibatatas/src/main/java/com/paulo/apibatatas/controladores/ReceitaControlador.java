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

import com.paulo.apibatatas.modelos.Receita;
import com.paulo.apibatatas.servicos.ReceitaServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receitas")
public class ReceitaControlador {
	
	@Autowired
	private ReceitaServico receitaServico;
	
	@GetMapping("")
	public ResponseEntity<?> verReceitas() {
		return receitaServico.verTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verReceita(@PathVariable long id) {
		return receitaServico.verPorId(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> adicionarReceita(@Valid @RequestBody Receita receita) {
		return receitaServico.adicionar(receita);
	}
	
	@PutMapping("")
	public ResponseEntity<?> alterarReceita(@Valid @RequestBody Receita receita) {
		return receitaServico.alterar(receita);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarReceita(@PathVariable long id) {
		return receitaServico.deletarPorId(id);
	}
}

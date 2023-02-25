package com.paulo.apibatatas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("")
	public ResponseEntity<?> adicionarBatatas(@Valid @RequestBody Batata batata) {
		return batataServico.adicionar(batata);
	}
}

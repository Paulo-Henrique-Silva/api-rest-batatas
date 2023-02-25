package com.paulo.apibatatas.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batatas")
public class Controlador {
	
	@GetMapping("")
	public String hello() {
		return "<h1>Hello World!</h1>";
	}
}

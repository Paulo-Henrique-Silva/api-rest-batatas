package com.paulo.apibatatas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulo.apibatatas.repositorios.PreparoRepositorio;

@Service
public class PreparoServico {
	
	@Autowired
	private PreparoRepositorio preparoRepositorio;
}

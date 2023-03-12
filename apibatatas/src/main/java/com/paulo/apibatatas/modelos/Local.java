package com.paulo.apibatatas.modelos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_locais")
public class Local {
	
	//colunas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	@NotBlank(message = "O campo de nome é obrigatório.")
	private String nome;
	
	@Column(name = "cidade")
	@NotBlank(message = "O campo de cidade é obrigatório.")
	private String cidade;
	
	@Column(name = "estado")
	@NotBlank(message = "O campo de estado é obrigatório.")
	private String estado;
	
	//atributos de relacionamentos
	@OneToMany(mappedBy = "local")
	@JsonIgnore
	private List<Batata> batatas = new ArrayList<>();
	
	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Batata> getBatatas() {
		return batatas;
	}

	public void setBatatas(List<Batata> batatas) {
		this.batatas = batatas;
	}

	public long getId() {
		return id;
	}
	
}

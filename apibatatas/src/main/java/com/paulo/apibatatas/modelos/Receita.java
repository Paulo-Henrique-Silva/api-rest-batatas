package com.paulo.apibatatas.modelos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paulo.apibatatas.enums.FormaBatata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_receitas")
public class Receita {
	
	//colunas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	@NotBlank(message = "O campo de nome é obrigatório.")
	private String nome;
	
	@Column(name = "forma")
	@NotNull(message = "O campo de forma é obrigatório.")
	@Enumerated(EnumType.STRING)
	private FormaBatata forma;
	
	@Column(name = "modo_fazer")
	@NotBlank(message = "O campo de modo de fazer é obrigatório.")
	private String modoFazer;
	
	//atributos de relacionamentos
	@ManyToMany(mappedBy = "receita")
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Preparo> preparos = new ArrayList<>();

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FormaBatata getForma() {
		return forma;
	}

	public void setForma(FormaBatata forma) {
		this.forma = forma;
	}

	public String getModoFazer() {
		return modoFazer;
	}

	public void setModoFazer(String modoFazer) {
		this.modoFazer = modoFazer;
	}

	public long getId() {
		return id;
	}

	public List<Preparo> getPreparos() {
		return preparos;
	}

	public void setPreparos(List<Preparo> preparos) {
		this.preparos = preparos;
	}
	
}

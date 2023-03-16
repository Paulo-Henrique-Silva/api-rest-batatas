package com.paulo.apibatatas.modelos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paulo.apibatatas.enums.CorBatata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_variedades")
public class Variedade {
	
	//colunas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	@NotBlank(message = "O campo de nome é obrigatório.")
	private String nome;
	
	@Column(name = "descricao_beneficios")
	@NotBlank(message = "O campo de descrição de benefícios é obrigatório.")
	private String descricaoBeneficios;
	
	@Column(name = "cor")
	@NotNull(message = "O campo de cor é obrigatório.")
	@Enumerated(EnumType.STRING)
	private CorBatata cor;
	
	//atributos de relacionamentos
	@OneToMany(mappedBy = "variedade")
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Batata> batatas = new ArrayList<>();
	
	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoBeneficios() {
		return descricaoBeneficios;
	}

	public void setDescricaoBeneficios(String descricaoBeneficios) {
		this.descricaoBeneficios = descricaoBeneficios;
	}

	public CorBatata getCor() {
		return cor;
	}

	public void setCor(CorBatata cor) {
		this.cor = cor;
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

package com.paulo.apibatatas.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_preparos")
public class Preparo {
	
	//colunas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "receita_id")
	@NotNull(message = "O campo de receita é obrigatório.")
	private Receita receita;
	
	@ManyToOne
	@JoinColumn(name = "batata_id")
	@NotNull(message = "O campo de batata é obrigatório.")
	private Batata batata;
	
	@Column(name = "tempo_minutos")
	@NotNull(message = "O campo de tempo é obrigatório.")
	private int tempoMinutos;
	
	@Column(name = "data_preparo")
	@NotNull(message = "O campo de data de preparo é obrigatório.")
	private LocalDate dataPreparo;
	
	//getters e setters
	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Batata getBatata() {
		return batata;
	}

	public void setBatata(Batata batata) {
		this.batata = batata;
	}

	public int getTempoMinutos() {
		return tempoMinutos;
	}

	public void setTempoMinutos(int tempoMinutos) {
		this.tempoMinutos = tempoMinutos;
	}

	public LocalDate getDataPreparo() {
		return dataPreparo;
	}

	public void setDataPreparo(LocalDate dataPreparo) {
		this.dataPreparo = dataPreparo;
	}

	public long getId() {
		return id;
	}
	
}

package com.paulo.apibatatas.modelos;

import com.paulo.apibatatas.enums.FormaBatata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_batatas")
public final class Batata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "nome_variedade")
	@NotBlank(message = "O campo de nome da variedade é obrigatória.")
	private String nomeVariedade;

	@Column(name = "tamanho_centimetros")
	@Positive
	private double tamanhoCentimetros;

	@Column(name = "massa_quilogramas")
	@Positive
	private double massaQuilogramas;

	@Column(name = "tempo_amadurecimento_dias")
	@Positive
	private int tempoAmadurecimentoDias;

	@Column(name = "foi_geneticamente_alterada")
	@NotNull
	private boolean foiGeneticamenteAlterada;
	
	@Column(name = "forma")
	@Enumerated(EnumType.STRING)
	@NotNull
	private FormaBatata forma;

	public String getNomeVariedade() {
		return nomeVariedade;
	}

	public void setNomeVariedade(String nomeVariedade) {
		this.nomeVariedade = nomeVariedade;
	}

	public double getTamanhoCentimetros() {
		return tamanhoCentimetros;
	}

	public void setTamanhoCentimetros(double tamanhoCentimetros) {
		this.tamanhoCentimetros = tamanhoCentimetros;
	}

	public double getMassaQuilogramas() {
		return massaQuilogramas;
	}

	public void setMassaQuilogramas(double massaQuilogramas) {
		this.massaQuilogramas = massaQuilogramas;
	}

	public int getTempoAmadurecimentoDias() {
		return tempoAmadurecimentoDias;
	}

	public void setTempoAmadurecimentoDias(int tempoAmadurecimentoDias) {
		this.tempoAmadurecimentoDias = tempoAmadurecimentoDias;
	}

	public boolean isFoiGeneticamenteAlterada() {
		return foiGeneticamenteAlterada;
	}

	public void setFoiGeneticamenteAlterada(boolean foiGeneticamenteAlterada) {
		this.foiGeneticamenteAlterada = foiGeneticamenteAlterada;
	}

	public FormaBatata getForma() {
		return forma;
	}

	public void setForma(FormaBatata forma) {
		this.forma = forma;
	}

	public long getId() {
		return id;
	}
	
}

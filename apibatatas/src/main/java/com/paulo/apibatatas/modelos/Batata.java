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
public class Batata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "nome_variedade")
	@NotBlank(message = "O campo de nome da variedade é obrigatório.")
	private String nomeVariedade;

	@Column(name = "tamanho_centimetros")
	@Positive(message = "O tamanho deve ser maior que zero.")
	private double tamanhoCentimetros;

	@Column(name = "massa_quilogramas")
	@Positive(message = "A massa deve ser maior que zero.")
	private double massaQuilogramas;

	@Column(name = "tempo_amadurecimento_dias")
	@Positive(message = "A quantidade de dias deve ser maior que zero.")
	private int tempoAmadurecimentoDias;

	@Column(name = "foi_geneticamente_alterada")
	@NotNull(message = "O campo de geneticamente alterada é obrigatório.")
	private boolean foiGeneticamenteAlterada;
	
	@Column(name = "forma")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo de forma é obrigatório.")
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

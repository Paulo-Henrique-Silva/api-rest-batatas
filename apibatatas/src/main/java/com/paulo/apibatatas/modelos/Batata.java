package com.paulo.apibatatas.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_batatas")
public class Batata {
	
	//colunas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "variedade_id")
	@NotNull(message = "O campo de variedade é obrigatório.")
	private Variedade variedade;
	
	@ManyToOne
	@JoinColumn(name = "local_id")
	@NotNull(message = "O campo de local é obrigatório.")
	private Local local;

	@Column(name = "tamanho_centimetros")
	@NotNull(message = "O campo de tamanho é obrigatório.")
	@Positive(message = "O tamanho deve ser maior que zero.")
	private double tamanhoCentimetros;

	@Column(name = "massa_quilogramas")
	@NotNull(message = "O campo de massa é obrigatório.")
	@Positive(message = "A massa deve ser maior que zero.")
	private double massaQuilogramas;
	
	@Column(name = "data_cultivo")
	@NotNull(message = "O campo de data é obrigatório.")
	private LocalDate dataCultivo;

	@Column(name = "geneticamente_alterada")
	@NotNull(message = "O campo de geneticamente alterada é obrigatório.")
	private boolean geneticamenteAlterada;
	
	@Column(name = "tempo_amadurecimento_dias")
	@NotNull(message = "O campo de tempo de amadurecimento é obrigatório.")
	@Positive(message = "A quantidade de dias deve ser maior que zero.")
	private int tempoAmadurecimentoDias;
	
	//atributos de relacionamentos
	@ManyToMany
	@JsonIgnore
	@JoinTable ( //determina que o id da batata é a fk principal da tabela de preparos.
		name = "tb_preparos",
		joinColumns = @JoinColumn(name = "batata_id"),
		inverseJoinColumns = @JoinColumn(name = "receita_id")
	)
	@OnDelete(action = OnDeleteAction.CASCADE) //após a batata ser deletada, os preparos que contêm sua fk são deletados.
	private List<Preparo> preparos = new ArrayList<>();

	//getters e setters
	public Variedade getVariedade() {
		return variedade;
	}

	public void setVariedade(Variedade variedade) {
		this.variedade = variedade;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
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

	public LocalDate getDataCultivo() {
		return dataCultivo;
	}

	public void setDataCultivo(LocalDate dataCultivo) {
		this.dataCultivo = dataCultivo;
	}

	public boolean isGeneticamenteAlterada() {
		return geneticamenteAlterada;
	}

	public void setGeneticamenteAlterada(boolean geneticamenteAlterada) {
		this.geneticamenteAlterada = geneticamenteAlterada;
	}

	public int getTempoAmadurecimentoDias() {
		return tempoAmadurecimentoDias;
	}

	public void setTempoAmadurecimentoDias(int tempoAmadurecimentoDias) {
		this.tempoAmadurecimentoDias = tempoAmadurecimentoDias;
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

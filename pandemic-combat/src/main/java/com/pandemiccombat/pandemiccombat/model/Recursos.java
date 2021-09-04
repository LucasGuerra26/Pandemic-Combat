package com.pandemiccombat.pandemiccombat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Recursos{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	/*
	 * quantidade de ambulancia disponivel hospital
	 */
	private Integer quantidadeDeAmbulancia;
	
	/*
	 * quantidade de enfermeiros trabalhando no hospital
	 */
	private Integer quantidadeDeEnfermeiros;
	
	/*
	 * quantidade de medicos trabalhando no hospital
	 */
	private Integer quantidadeDeMedicos;
	
	/*
	 * quantidade de respiradores disponivel no hospital
	 */
	private Integer quantidadeDeRespiradores;
	
	/*
	 * quantidade de tomógrafos disponivel no hospital
	 */
	private Integer quantidadeDeTomografos;
	
	public Recursos() {}
	
	/*
	 * Construtor da classe usado na adição de um hospital que consequentemente adiciona recursos a ele
	 * recebe como parametro as quantidades referente a ambulâncias, enfermeiros, medicos, respiradores
	 * e tomógrafos
	 */
	public Recursos(Integer quantidadeDeAmbulancia, Integer quantidadeDeEnfermeiros, Integer quantidadeDeMedicos, Integer quantidadeDeRespiradores, Integer quantidadeDeTomografos) {
		this.quantidadeDeAmbulancia = quantidadeDeAmbulancia;
		this.quantidadeDeEnfermeiros = quantidadeDeEnfermeiros;
		this.quantidadeDeMedicos = quantidadeDeMedicos;
		this.quantidadeDeRespiradores = quantidadeDeRespiradores;
		this.quantidadeDeTomografos = quantidadeDeTomografos;
		
	}
	
	/*
	 * retorna a quantidade de ambulancias do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeAmbulancia() {
		return quantidadeDeAmbulancia;
	}

	/*
	 * altera a quantidade de ambulancias de um hospital, recebe como parametro a nova quantidade de recursos
	 */
	public void setQuantidadeDeAmbulancia(Integer quantidadeDeAmbulancia) {
		this.quantidadeDeAmbulancia = quantidadeDeAmbulancia;
	}

	/*
	 * retorna a quantidade de enfermeiros do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeEnfermeiros() {
		return quantidadeDeEnfermeiros;
	}

	/*
	 * altera a quantidade de enfermeiros de um hospital, recebe como parametro a nova quantidade de enfermeiros
	 */
	public void setQuantidadeDeEnfermeiros(Integer quantidadeDeEnfermeiros) {
		this.quantidadeDeEnfermeiros = quantidadeDeEnfermeiros;
	}

	/*
	 * retorna a quantidade de médicos do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeMedicos() {
		return quantidadeDeMedicos;
	}

	/*
	 * altera a quantidade de medicos de um hospital, recebe como parametro a nova quantidade de medicos
	 */
	public void setQuantidadeDeMedicos(Integer quantidadeDeMedicos) {
		this.quantidadeDeMedicos = quantidadeDeMedicos;
	}

	/*
	 * retorna a quantidade de respiradores do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeRespiradores() {
		return quantidadeDeRespiradores;
	}

	/*
	 * altera a quantidade de respiradores de um hospital, recebe como parametro a nova quantidade de respiradores
	 */
	public void setQuantidadeDeRespiradores(Integer quantidadeDeRespiradores) {
		this.quantidadeDeRespiradores = quantidadeDeRespiradores;
	}

	/*
	 * retorna a quantidade de tomógrafos do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeTomografos() {
		return quantidadeDeTomografos;
	}

	/*
	 * altera a quantidade de tomógrafos de um hospital, recebe como parametro a nova quantidade de tomógrafos
	 */
	public void setQuantidadeDeTomografos(Integer quantidadeDeTomografos) {
		this.quantidadeDeTomografos = quantidadeDeTomografos;
	}

	/*
	 * retorna a chave primária referente a localização do objeto no banco de dados
	 */
	public Long getId() {
		return Id;
	}

}

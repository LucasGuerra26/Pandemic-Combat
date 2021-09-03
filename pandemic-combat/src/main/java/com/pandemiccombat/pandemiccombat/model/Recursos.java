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
	
	private Integer quantidadeDeAmbulancia;
	private Integer quantidadeDeEnfermeiros;
	private Integer quantidadeDeMedicos;
	private Integer quantidadeDeRespiradores;
	private Integer quantidadeDeTomografos;
	
	public Recursos() {}
	
	public Recursos(Integer quantidadeDeAmbulancia, Integer quantidadeDeEnfermeiros, Integer quantidadeDeMedicos, Integer quantidadeDeRespiradores, Integer quantidadeDeTomografos) {
		this.quantidadeDeAmbulancia = quantidadeDeAmbulancia;
		this.quantidadeDeEnfermeiros = quantidadeDeEnfermeiros;
		this.quantidadeDeMedicos = quantidadeDeMedicos;
		this.quantidadeDeRespiradores = quantidadeDeRespiradores;
		this.quantidadeDeTomografos = quantidadeDeTomografos;
		
	}
	public Integer getQuantidadeDeAmbulancia() {
		return quantidadeDeAmbulancia;
	}

	public void setQuantidadeDeAmbulancia(Integer quantidadeDeAmbulancia) {
		this.quantidadeDeAmbulancia = quantidadeDeAmbulancia;
	}

	public Integer getQuantidadeDeEnfermeiros() {
		return quantidadeDeEnfermeiros;
	}

	public void setQuantidadeDeEnfermeiros(Integer quantidadeDeEnfermeiros) {
		this.quantidadeDeEnfermeiros = quantidadeDeEnfermeiros;
	}

	public Integer getQuantidadeDeMedicos() {
		return quantidadeDeMedicos;
	}

	public void setQuantidadeDeMedicos(Integer quantidadeDeMedicos) {
		this.quantidadeDeMedicos = quantidadeDeMedicos;
	}

	public Integer getQuantidadeDeRespiradores() {
		return quantidadeDeRespiradores;
	}

	public void setQuantidadeDeRespiradores(Integer quantidadeDeRespiradores) {
		this.quantidadeDeRespiradores = quantidadeDeRespiradores;
	}

	public Integer getQuantidadeDeTomografos() {
		return quantidadeDeTomografos;
	}

	public void setQuantidadeDeTomografos(Integer quantidadeDeTomografos) {
		this.quantidadeDeTomografos = quantidadeDeTomografos;
	}

	public Long getId() {
		return Id;
	}

}

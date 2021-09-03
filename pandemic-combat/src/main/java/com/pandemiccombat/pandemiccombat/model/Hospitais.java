package com.pandemiccombat.pandemiccombat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospitais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private long CNPJ;
	
	private String nome;
	
	private String endereco;
	
	private Integer ocupacao;
	
	private String localizacao;
	
	private Hospitais() {}
	
	public Hospitais(Long CNPJ, String nome, String endereco, Integer ocupacao, String localizacao) {
		this.CNPJ = CNPJ;
		this.nome = nome;
		this.endereco = endereco;
		this.ocupacao = ocupacao;
		this.localizacao = localizacao;
	}
	public Long getId() {
		return id;
	}
	
	public long getCnpj() {
		return CNPJ;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(Integer ocupacao) {
		this.ocupacao = ocupacao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	
	
}

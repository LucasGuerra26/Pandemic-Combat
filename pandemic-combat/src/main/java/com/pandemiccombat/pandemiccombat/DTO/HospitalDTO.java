package com.pandemiccombat.pandemiccombat.DTO;

public class HospitalDTO {
	
	private long cnpj;
	private String nome;
	private String endereco;
	private Integer ocupacao;
	private String localizacao;
	private Integer quantidadeDeAmbulancia;
	private Integer quantidadeDeEnfermeiros;
	private Integer quantidadeDeMedicos;
	private Integer quantidadeDeRespiradores;
	private Integer quantidadeDeTomografos;

	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public Integer getOcupacao() {
		return ocupacao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public long getCnpj() {
		return cnpj;
	}
	
	public Integer getQuantidadeDeAmbulancia() {
		return quantidadeDeAmbulancia;
	}
	
	public Integer getQuantidadeDeEnfermeiros() {
		return quantidadeDeEnfermeiros;
	}
	
	public Integer getQuantidadeDeMedicos() {
		return quantidadeDeMedicos;
	}
	
	public Integer getQuantidadeDeRespiradores() {
		return quantidadeDeRespiradores;
	}
	
	public Integer getQuantidadeDeTomografos() {
		return quantidadeDeTomografos;
	}

}

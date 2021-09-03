package com.pandemiccombat.pandemiccombat.DTO;

public class HospitalDTO {
	
	private long cnpj;
	private String nome;
	private String endereco;
	private Integer ocupacao;
	private String localizacao;
	
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

}

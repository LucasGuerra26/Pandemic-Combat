package com.pandemiccombat.pandemiccombat.DTO;

/*
 * Classe que provê tudo que é necessário para o processo de adição de um hospital ao sistema
 */
public class HospitalDTO {
	
	/*
	 * cnpj do hospital
	 */
	private long cnpj;
	
	
	/*
	 * nome do hospital
	 */
	private String nome;
	
	/*
	 * endereco do hospital
	 */
	private String endereco;
	
	/*
	 * ocupacao atual do hospital
	 */
	private Integer ocupacao;
	
	/*
	 * localizacao do hospital (latitude, longitude)
	 */
	private String localizacao;
	
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

	/*
	 * retorna o nome do hospital para ser usado na adição do mesmo no sistema
	 */
	public String getNome() {
		return nome;
	}
	
	/*
	 * retorna o endereco do hospital para ser usado na adição do mesmo no sistema
	 */
	public String getEndereco() {
		return endereco;
	}
	
	/*
	 * retorna a ocupação do hospital para ser usado na adição do mesmo no sistema
	 */
	public Integer getOcupacao() {
		return ocupacao;
	}
	
	/*
	 * retorna a localização do hospital para ser usado na adição do mesmo no sistema
	 */
	public String getLocalizacao() {
		return localizacao;
	}
	
	/*
	 * retorna o CNPJ do hospital para ser usado na adição do mesmo no sistema
	 */
	public long getCnpj() {
		return cnpj;
	}
	
	/*
	 * retorna a quantidade de ambulancias do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeAmbulancia() {
		return quantidadeDeAmbulancia;
	}
	
	/*
	 * retorna a quantidade de enfermeiros do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeEnfermeiros() {
		return quantidadeDeEnfermeiros;
	}
	
	/*
	 * retorna a quantidade de médicos do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeMedicos() {
		return quantidadeDeMedicos;
	}
	
	/*
	 * retorna a quantidade de respiradores do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeRespiradores() {
		return quantidadeDeRespiradores;
	}
	
	/*
	 * retorna a quantidade de tomógrafos do hospital para ser usado na adição do mesmo e seus recursos no sistema
	 */
	public Integer getQuantidadeDeTomografos() {
		return quantidadeDeTomografos;
	}


}

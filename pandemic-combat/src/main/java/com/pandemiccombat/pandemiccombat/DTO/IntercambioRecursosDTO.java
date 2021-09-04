package com.pandemiccombat.pandemiccombat.DTO;

public class IntercambioRecursosDTO {

	/*
	 * CNPJ do hospital que ta intercambiando recursos
	 */
	private long cnpjHospital1;
	
	/*
	 * CNPJ do hospital que ta intercambiando recursos
	 */
	private long cnpjHospital2;
	
	/*
	 * quantidade de ambulancia que o hospital 1 está mandando para o hospital 2
	 */
	private Integer quantidadeDeAmbulanciaHospital1;
	
	/*
	 * quantidade de enfermeiros que o hospital 1 está mandando para o hospital 2
	 */
	private Integer quantidadeDeEnfermeirosHospital1;
	
	/*
	 * quantidade de medicos que o hospital 1 está mandando para o hospital 2
	 */
	private Integer quantidadeDeMedicosHospital1;
	
	/*
	 * quantidade de respiradores que o hospital 1 está mandando para o hospital 2
	 */
	private Integer quantidadeDeRespiradoresHospital1;
	
	/*
	 * quantidade de tomógrafos que o hospital 1 está mandando para o hospital 2
	 */
	private Integer quantidadeDeTomografosHospital1;

	/*
	 * quantidade de ambulancia que o hospital 2 está mandando para o hospital 1
	 */
	private Integer quantidadeDeAmbulanciaHospital2;
	
	/*
	 * quantidade de enfermeiros que o hospital 2 está mandando para o hospital 1
	 */
	private Integer quantidadeDeEnfermeirosHospital2;
	
	/*
	 * quantidade de medicos que o hospital 2 está mandando para o hospital 1
	 */
	private Integer quantidadeDeMedicosHospital2;
	
	/*
	 * quantidade de respiradores que o hospital 2 está mandando para o hospital 1
	 */
	private Integer quantidadeDeRespiradoresHospital2;
	
	/*
	 * quantidade de tomógrafos que o hospital 2 está mandando para o hospital 1
	 */
	private Integer quantidadeDeTomografosHospital2;

	public long getCnpjHospital1() {
		return cnpjHospital1;
	}

	public long getCnpjHospital2() {
		return cnpjHospital2;
	}

	public Integer getQuantidadeDeAmbulanciaHospital1() {
		return quantidadeDeAmbulanciaHospital1;
	}

	public Integer getQuantidadeDeEnfermeirosHospital1() {
		return quantidadeDeEnfermeirosHospital1;
	}

	public Integer getQuantidadeDeMedicosHospital1() {
		return quantidadeDeMedicosHospital1;
	}

	public Integer getQuantidadeDeRespiradoresHospital1() {
		return quantidadeDeRespiradoresHospital1;
	}

	public Integer getQuantidadeDeTomografosHospital1() {
		return quantidadeDeTomografosHospital1;
	}

	public Integer getQuantidadeDeAmbulanciaHospital2() {
		return quantidadeDeAmbulanciaHospital2;
	}

	public Integer getQuantidadeDeEnfermeirosHospital2() {
		return quantidadeDeEnfermeirosHospital2;
	}

	public Integer getQuantidadeDeMedicosHospital2() {
		return quantidadeDeMedicosHospital2;
	}

	public Integer getQuantidadeDeRespiradoresHospital2() {
		return quantidadeDeRespiradoresHospital2;
	}

	public Integer getQuantidadeDeTomografosHospital2() {
		return quantidadeDeTomografosHospital2;
	}
}

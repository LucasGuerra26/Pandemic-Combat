package com.pandemiccombat.pandemiccombat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pandemiccombat.pandemiccombat.DTO.IntercambioRecursosDTO;

/*
 * Classe referente as negociações de recursos entre os hospitais
 */
@Entity
public class IntercambioDeRecursos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*
	 * nome do hospital que ta intercambiando recursos
	 */
	private String nomeHospital1;
	
	/*
	 * nome do hospital que ta intercambiando recursos
	 */
	private String nomeHospital2;
	
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
	
	public IntercambioDeRecursos() {}
	
	public IntercambioDeRecursos(String nH1, String nH2, IntercambioRecursosDTO iR ) {
		
		this.nomeHospital1 = nH1;
		this.nomeHospital2 = nH2;
		this.quantidadeDeAmbulanciaHospital1 = iR.getQuantidadeDeAmbulanciaHospital1();
		this.quantidadeDeEnfermeirosHospital1 = iR.getQuantidadeDeEnfermeirosHospital1();
		this.quantidadeDeMedicosHospital1 = iR.getQuantidadeDeMedicosHospital1();
		this.quantidadeDeRespiradoresHospital1 = iR.getQuantidadeDeRespiradoresHospital1();
		this.quantidadeDeTomografosHospital1 = iR.getQuantidadeDeTomografosHospital1();
		
		this.quantidadeDeAmbulanciaHospital2 = iR.getQuantidadeDeAmbulanciaHospital2();
		this.quantidadeDeEnfermeirosHospital2 = iR.getQuantidadeDeEnfermeirosHospital2();
		this.quantidadeDeMedicosHospital2 = iR.getQuantidadeDeMedicosHospital2();
		this.quantidadeDeRespiradoresHospital2 = iR.getQuantidadeDeRespiradoresHospital2();
		this.quantidadeDeTomografosHospital2 = iR.getQuantidadeDeTomografosHospital2();
	}

	public String getNomeHospital1() {
		return nomeHospital1;
	}

	public String getNomeHospital2() {
		return nomeHospital2;
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
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return    "Intercambio de recursos id=" + id + "\n"
				+ "Nome do primeiro hospital:" + nomeHospital1 +"\n"
				+ "Nome do Segundo Hospital:"
				+ nomeHospital2 +"\n"
				+ "Quantidade de ambulâncias eniviadas do primeiro hospital: " + quantidadeDeAmbulanciaHospital1 +"\n"
				+ "Quantidade de enfermeiros eniviados do primeiro hospital: " + quantidadeDeEnfermeirosHospital1 +"\n"
				+ "Quantidade de médicos eniviados do primeiro hospital: " + quantidadeDeMedicosHospital1 +"\n"
				+ "Quantidade de respiradores eniviados do primeiro hospital: " + quantidadeDeRespiradoresHospital1 +"\n"
				+ "Quantidade de tomógrafos eniviados do primeiro hospital: " + quantidadeDeTomografosHospital1 +"\n"
				+ "Quantidade de ambulâncias eniviadas do segundo hospital: " + quantidadeDeAmbulanciaHospital2 +"\n"
				+ "Quantidade de enfermeiros eniviados do segundo hospital: " + quantidadeDeEnfermeirosHospital2 +"\n"
				+ "Quantidade de médicos eniviados do segundo hospital: " + quantidadeDeMedicosHospital2 +"\n"
				+ "Quantidade de respiradores eniviados do segundo hospital: " + quantidadeDeRespiradoresHospital2 +"\n"
				+ "Quantidade de tomógrafos eniviados do segundo hospital: " + quantidadeDeTomografosHospital2 + "\n"+"\n";
	}
	
	
}

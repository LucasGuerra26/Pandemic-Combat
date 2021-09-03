package com.pandemiccombat.pandemiccombat.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;


@Entity
public class Hospitais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// variavel referente ao cnpj do hospital
	@NotNull
	private long CNPJ;
	
	// variavel referente ao nome do hospital
	private String nome;
	
	//variavel referente ao endereço do hospital
	private String endereco;
	
	//variavel de percentual de ocupacao
	private Integer ocupacao;
	
	//variavel referente a localizacao do hospital
	private String localizacao;
	
	// variavel de sinalizacao de alta ocupacao
	private Boolean estaComAltaOcupacao;
	
	//data de controle do tempo em que o hospital estará em alta ou baixa ocupacao
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeControleDeOcupacao;
	
	@OneToOne
	private Recursos recursos;
	
	private Hospitais() {}
	
	public Hospitais(Long CNPJ, String nome, String endereco, Integer ocupacao, String localizacao) {
		this.CNPJ = CNPJ;
		this.nome = nome;
		this.endereco = endereco;
		this.ocupacao = ocupacao;
		this.localizacao = localizacao;
		dataDeControleDeOcupacao = new Date();
		if (ocupacao >= 90) {estaComAltaOcupacao = true;}
		else {estaComAltaOcupacao = false;}
		this.recursos = new Recursos();
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
	
	public Date getDataDeControleDeOcupacao() {
		return dataDeControleDeOcupacao;
	}

	public void setDataDeControleDeOcupacao(Date dataDeControleDeOcupacao) {
		this.dataDeControleDeOcupacao = dataDeControleDeOcupacao;
	}
	
	public Boolean EstaComAltaOcupacao() {
		return estaComAltaOcupacao;
	}

	public void setEstaComAltaOcupacao(boolean estaComAltaOcupacao) {
		this.estaComAltaOcupacao = estaComAltaOcupacao;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospitais other = (Hospitais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Recursos getRecursos() {
		return recursos;
	}

	public void setRecursos(Recursos recursos) {
		this.recursos = recursos;
	}
	
}

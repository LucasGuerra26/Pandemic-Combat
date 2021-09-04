package com.pandemiccombat.pandemiccombat.model;



import java.util.Date;

import javax.persistence.CascadeType;
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

	/*
	 * variavel referente ao cnpj do hospital
	 */
	@NotNull
	private long CNPJ;
	
	/*
	 * variavel referente ao nome do hospital
	 */
	private String nome;
	
	/*
	 * variavel referente ao endereço do hospital
	 */
	private String endereco;
	
	/*
	 * variavel de percentual de ocupacao
	 */
	private Integer ocupacao;
	
	/*
	 * variavel referente a localizacao do hospital
	 */
	private String localizacao;
	
	/*
	 * variavel de sinalizacao de alta ocupacao
	 */
	private Boolean estaComAltaOcupacao;
	
	/*
	 * data de controle do tempo em que o hospital estará em alta ou baixa ocupacao
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeControleDeOcupacao;
	
	/*
	 * recursos do hospital
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private Recursos recursos;
	
	private Hospitais() {}
	
	/*
	 * construtor usado na adição de hospitais no sistema, recebe como parametro as informações de CNPJ, nome, endereco, ocupacao
	 * e localização do hospital. O construtor ja adiciona a data e altera a variavel de sinalização dependendo do percentual
	 * de ocupação do hospital, true para ocupação maior ou igual a 90, e false caso contrário
	 */
	public Hospitais(Recursos r, Long CNPJ, String nome, String endereco, Integer ocupacao, String localizacao) {
		this.CNPJ = CNPJ;
		this.nome = nome;
		this.endereco = endereco;
		this.ocupacao = ocupacao;
		this.localizacao = localizacao;
		dataDeControleDeOcupacao = new Date();
		if (ocupacao >= 90) {estaComAltaOcupacao = true;}
		else {estaComAltaOcupacao = false;}
		this.recursos = r;
	}
	
	/*
	 * retorna a chave primária referente a localização no banco de dados
	 */
	public Long getId() {
		return id;
	}
	
	/*
	 * retorna o CNPJ do hospital 
	 */
	public long getCnpj() {
		return CNPJ;
	}
	
	/*
	 * retorna o nome do hospital 
	 */
	public String getNome() {
		return nome;
	}
	
	/*
	 * edita o nome do hospital, recebe o novo nome como parametro
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*
	 * retorna o endereco do hospital
	 */
	public String getEndereco() {
		return endereco;
	}
	
	/*
	 * edita o endereço do hospital, recebe o novo endereço como parametro
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/*
	 * retorna a ocupação do hospital
	 */
	public Integer getOcupacao() {
		return ocupacao;
	}
	
	/*
	 * edita a porcentagem de ocupacao do hospital, recebe a nova ocupacao como parametro
	 */
	public void setOcupacao(Integer ocupacao) {
		this.ocupacao = ocupacao;
	}
	
	/*
	 * retorna a localização do hospital
	 */
	public String getLocalizacao() {
		return localizacao;
	}
	
	/*
	 * retorna a data de controle de ocupação do hospital
	 */
	public Date getDataDeControleDeOcupacao() {
		return dataDeControleDeOcupacao;
	}

	/*
	 * altera a data de controle de ocupação, recebe a nova data como parametro.
	 * este método é usado quando ocorre a edição da ocupação se caso a ocupação passe de alta para baixa
	 * ou vice versa uma nova data de controle será armazenada
	 */
	public void setDataDeControleDeOcupacao(Date dataDeControleDeOcupacao) {
		this.dataDeControleDeOcupacao = dataDeControleDeOcupacao;
	}
	
	/*
	 * retorna true se o hospital estiver com ocupação maior igual a 90% e false caso contrário
	 */
	public Boolean EstaComAltaOcupacao() {
		return estaComAltaOcupacao;
	}

	/*
	 * altera o sinalizador de alta ocupação
	 * este método é usado quando ocorre a edição da ocupação se caso a ocupação passe de alta para baixa
	 * ou vice versa a variável estaComAltaOcupcao é alterada
	 */
	public void setEstaComAltaOcupacao(boolean estaComAltaOcupacao) {
		this.estaComAltaOcupacao = estaComAltaOcupacao;
	}

	/*
	 * retorna os recursos do hospital
	 */
	public Recursos getRecursos() {
		return recursos;
	}
	
	/*
	 * altera os recursos de um hospital, recebe como parametro seus novos recursos
	 */
	public void setRecursos(Recursos recurso) {
		this.recursos = recursos;
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

	
}

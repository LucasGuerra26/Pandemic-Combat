package com.pandemiccombat.pandemiccombat.service;

import java.util.List;
import java.util.Optional;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
import com.pandemiccombat.pandemiccombat.model.Recursos;

/*
 * interface de controle
 */
public interface HospitalService {

	/*
	 * retorna um hospital a partir de seu id usando jpa repository
	 */
	public Optional<Hospitais> getHospitalByCNPJ(Long cnpj);
	
	/*
	 * cria um novo hospital no sistema
	 */
	public Hospitais criaHospital (Recursos r, HospitalDTO hospitalDto);
	
	/*
	 * salva o hospital criado no banco de dados usando jpa repository
	 */
	public void salvarHospitalCadastrado(Hospitais hospital);
	
	/*
	 * altera a ocupação de um hospital, recebe como parametro o hospital e a sua nova ocupação
	 */
	public Hospitais alteraOcupacao (Hospitais hospital, Integer ocupacao);
	
	/*
	 * retorna um relatório com a porcentagem de hospitais que estão com sua
	 * ocupação maior ou igual a 90%
	 */
	public String getRelatorioOcupacaoMaiorNoventa();
	
	/*
	 * retorna um relatório com a porcentagem de hospitais que estão com sua
	 * ocupação menor que 90%
	 */
	public String getRelatorioOcupacaoMenorNoventa();
	
	/*
	 * retorna o hospital que está com alta ocupação a mais tempo.
	 */
	public List<Hospitais> getHospitalAMaisTempoComAltaOcupacao();
	
	/*
	 * retorna o hospital que está com baixa ocupação a mais tempo.
	 */
	public List<Hospitais>getHospitalAMaisTempoComBaixaOcupacao();
}

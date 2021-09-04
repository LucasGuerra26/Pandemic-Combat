package com.pandemiccombat.pandemiccombat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
import com.pandemiccombat.pandemiccombat.model.Recursos;
import com.pandemiccombat.pandemiccombat.repository.HospitalRepository;

/*
 * classe de implementação lógica do sistema
 */
@Service
public class HospitalServiceImpl implements HospitalService{

	/*
	 * hospitalRepository é utilizado para persistir os dados no banco de dados a partir do jpa
	 */
	@Autowired
	HospitalRepository hospitalRepository;
	
	/*
	 * retorna um hospital a partir de seu id usando jpa repository
	 */
	@Override
	public Optional<Hospitais> getHospitalByCNPJ(Long cnpj) {
		return hospitalRepository.findByCNPJ(cnpj);
	}
	
	/*
	 * cria um novo hospital no sistema
	 */
	@Override
	public Hospitais criaHospital(Recursos r, HospitalDTO hospitalDto) {
		Hospitais hospital = new Hospitais (r, hospitalDto.getCnpj(), hospitalDto.getNome(), 
				hospitalDto.getEndereco(), hospitalDto.getOcupacao(), hospitalDto.getLocalizacao());
		return hospital;
	}
	
	/*
	 * salva o hospital criado no banco de dados usando jpa repository
	 */
	@Override
	public void salvarHospitalCadastrado(Hospitais hospital) {
		hospitalRepository.save(hospital);	
	}
	
	/*
	 * altera a ocupação de um hospital, recebe como parametro o hospital e a sua nova ocupação
	 */
	@Override
	public Hospitais alteraOcupacao(Hospitais hospital, Integer ocupacao) {
		if (!hospital.EstaComAltaOcupacao() && ocupacao>=90) {
			hospital.setOcupacao(ocupacao);
			hospital.setDataDeControleDeOcupacao(new Date());
			hospital.setEstaComAltaOcupacao(true);
			
		}else if (!hospital.EstaComAltaOcupacao() && ocupacao<=90) {
			hospital.setOcupacao(ocupacao);
			
		}else if (hospital.EstaComAltaOcupacao() && ocupacao<=90) {
			hospital.setOcupacao(ocupacao);
			hospital.setDataDeControleDeOcupacao(new Date());
			hospital.setEstaComAltaOcupacao(false);
		}else if (hospital.EstaComAltaOcupacao() && ocupacao>=90) {
			hospital.setOcupacao(ocupacao);
		}
		
		return hospital;
	}
	
	/*
	 * atualiza os recursos de um hospital, recebe como parametro o hospital e seus novos recursos
	 */
	@Override
	public void atualizaRecursos(Recursos recursos, Hospitais hospital) {
		hospital.setRecursos(recursos);
	}
	
	/*
	 * retorna um relatório com a porcentagem de hospitais que estão com sua
	 * ocupação maior ou igual a 90%
	 */
	@Override
	public String getRelatorioOcupacaoMaiorNoventa() {
		ArrayList<Hospitais> hospitais = (ArrayList<Hospitais>) hospitalRepository.buscarHospitaisComOcupacaoSuperiorANoventa();
		Integer numeroDeHospitaisAltaOcupacao = hospitais.size();
		Integer numeroTotalDeHospitais = hospitalRepository.findAll().size();
		int percentual = (int)((numeroDeHospitaisAltaOcupacao.floatValue() /numeroTotalDeHospitais.floatValue())*100);
		String resultado = ""+percentual+"%"; 
		return resultado;
	}
	
	/*
	 * retorna um relatório com a porcentagem de hospitais que estão com sua
	 * ocupação menor que 90%
	 */
	public String getRelatorioOcupacaoMenorNoventa() {
		ArrayList<Hospitais> hospitais = (ArrayList<Hospitais>) hospitalRepository.buscarHospitaisComOcupacaoInferiorANoventa();
		Integer numeroDeHospitaisAltaOcupacao = hospitais.size();
		Integer numeroTotalDeHospitais = hospitalRepository.findAll().size();
		int percentual = (int)((numeroDeHospitaisAltaOcupacao.floatValue() /numeroTotalDeHospitais.floatValue())*100);
		String resultado = ""+percentual+"%"; 
		return resultado;
	}

	/*
	 * retorna o hospital que está com alta ocupação a mais tempo.
	 */
	@Override
	public List<Hospitais> getHospitalAMaisTempoComAltaOcupacao() {
		List<Hospitais> h = hospitalRepository.buscarHospitalMaisAntigoComOcupacaoSuperiorANoventa();
		return h;
	}
	
	/*
	 * retorna o hospital que está com baixa ocupação a mais tempo.
	 */
	@Override
	public List<Hospitais> getHospitalAMaisTempoComBaixaOcupacao() {
		List<Hospitais> h = hospitalRepository.buscarHospitalMaisAntigoComOcupacaoInferiorANoventa();
		return h;
	}

}

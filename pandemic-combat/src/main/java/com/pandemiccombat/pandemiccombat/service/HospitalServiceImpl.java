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

@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	HospitalRepository hospitalRepository;
	
	@Override
	public Optional<Hospitais> getHospitalByCNPJ(Long cnpj) {
		return hospitalRepository.findByCNPJ(cnpj);
	}
	
	@Override
	public Hospitais criaHospital(HospitalDTO hospitalDto) {
		Hospitais hospital = new Hospitais (hospitalDto.getCnpj(), hospitalDto.getNome(), 
				hospitalDto.getEndereco(), hospitalDto.getOcupacao(), hospitalDto.getLocalizacao());
		return hospital;
	}
	
	
	@Override
	public void salvarHospitalCadastrado(Hospitais hospital) {
		hospitalRepository.save(hospital);	
	}
	
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
	
	@Override
	public Optional<Hospitais> getHospitalById(long id) {
		return hospitalRepository.findById(id);
	}
	
	@Override
	public void atualizaRecursos(Recursos recursos, Hospitais hospital) {
		hospital.setRecursos(recursos);
	}
	
	@Override
	public String getRelatorioOcupacaoMaiorNoventa() {
		ArrayList<Hospitais> hospitais = (ArrayList<Hospitais>) hospitalRepository.buscarHospitaisComOcupacaoSuperiorANoventa();
		Integer numeroDeHospitaisAltaOcupacao = hospitais.size();
		Integer numeroTotalDeHospitais = hospitalRepository.findAll().size();
		int percentual = (int)((numeroDeHospitaisAltaOcupacao.floatValue() /numeroTotalDeHospitais.floatValue())*100);
		String resultado = ""+percentual+"%"; 
		return resultado;
	}
	
	public String getRelatorioOcupacaoMenorNoventa() {
		ArrayList<Hospitais> hospitais = (ArrayList<Hospitais>) hospitalRepository.buscarHospitaisComOcupacaoInferiorANoventa();
		Integer numeroDeHospitaisAltaOcupacao = hospitais.size();
		Integer numeroTotalDeHospitais = hospitalRepository.findAll().size();
		int percentual = (int)((numeroDeHospitaisAltaOcupacao.floatValue() /numeroTotalDeHospitais.floatValue())*100);
		String resultado = ""+percentual+"%"; 
		return resultado;
	}

	@Override
	public List<Hospitais> getHospitalAMaisTempoComAltaOcupacao() {
		List<Hospitais> h = hospitalRepository.buscarHospitalMaisAntigoComOcupacaoSuperiorANoventa();
		return h;
	}
	
	@Override
	public List<Hospitais> getHospitalAMaisTempoComBaixaOcupacao() {
		List<Hospitais> h = hospitalRepository.buscarHospitalMaisAntigoComOcupacaoInferiorANoventa();
		return h;
	}

}

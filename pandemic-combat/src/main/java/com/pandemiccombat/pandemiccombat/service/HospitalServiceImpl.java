package com.pandemiccombat.pandemiccombat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
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

}

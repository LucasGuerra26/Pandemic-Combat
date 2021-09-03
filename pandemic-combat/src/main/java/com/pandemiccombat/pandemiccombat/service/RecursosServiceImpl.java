package com.pandemiccombat.pandemiccombat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Recursos;
import com.pandemiccombat.pandemiccombat.repository.RecursosRepository;

@Service
public class RecursosServiceImpl implements RecursosService {

	@Autowired
	RecursosRepository recursosRepository;
	
	@Override
	public Recursos criaRecursos(HospitalDTO hospitalDTO) {
		Recursos recursos = new Recursos(hospitalDTO.getQuantidadeDeAmbulancia(), hospitalDTO.getQuantidadeDeEnfermeiros(),
				hospitalDTO.getQuantidadeDeMedicos(), hospitalDTO.getQuantidadeDeRespiradores(), hospitalDTO.getQuantidadeDeTomografos());
		return recursos;
	}

	@Override
	public void salvarRecursos(Recursos recursos) {
		recursosRepository.save(recursos);
		
	}

}

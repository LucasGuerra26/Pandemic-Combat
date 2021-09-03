package com.pandemiccombat.pandemiccombat.service;

import java.util.Optional;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;

public interface HospitalService {

	public Optional<Hospitais> getHospitalByCNPJ(Long cnpj);
	public Hospitais criaHospital (HospitalDTO hospitalDto);
	public void salvarHospitalCadastrado(Hospitais hospital);
}

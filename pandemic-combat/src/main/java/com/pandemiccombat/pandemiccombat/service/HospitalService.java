package com.pandemiccombat.pandemiccombat.service;

import java.util.List;
import java.util.Optional;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
import com.pandemiccombat.pandemiccombat.model.Recursos;

public interface HospitalService {

	public Optional<Hospitais> getHospitalByCNPJ(Long cnpj);
	public Hospitais criaHospital (HospitalDTO hospitalDto);
	public void salvarHospitalCadastrado(Hospitais hospital);
	public Hospitais alteraOcupacao (Hospitais hospital, Integer ocupacao);
	public Optional<Hospitais> getHospitalById(long id);
	public void atualizaRecursos(Recursos recursos, Hospitais hospital);
	public String getRelatorioOcupacaoMaiorNoventa();
	public String getRelatorioOcupacaoMenorNoventa();
	public List<Hospitais> getHospitalAMaisTempoComAltaOcupacao();
	public List<Hospitais>getHospitalAMaisTempoComBaixaOcupacao();
}

package com.pandemiccombat.pandemiccombat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemiccombat.pandemiccombat.DTO.IntercambioRecursosDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
import com.pandemiccombat.pandemiccombat.model.IntercambioDeRecursos;
import com.pandemiccombat.pandemiccombat.model.Recursos;
import com.pandemiccombat.pandemiccombat.repository.HospitalRepository;
import com.pandemiccombat.pandemiccombat.repository.IntercambioDeRecursosRepository;
import com.pandemiccombat.pandemiccombat.repository.RecursosRepository;
import com.pandemiccombat.pandemiccombat.util.Util;

/*
 * classe de implementação lógica do sistema
 */
@Service
public class IntercambioServiceImpl implements IntercambioService{

	@Autowired
	HospitalRepository hospitalRepository;
	@Autowired
	IntercambioDeRecursosRepository intercambioRepository;
	@Autowired
	RecursosRepository recursosRepository;
	
	/*
	 * Esse método recebe por meio do corpo de solicitação a informação referente aos dois hospitais
	 * que estão realizando intercambio de recursos, além disso também recebe a quantidade e quais recursos
	 * irão ser compartilhados. Este método atualiza os recursos de ambos os hospitais. Antes do intercambio
	 * acontecer, é delegado a função de teste para classe util.
	 */
	@Override
	public String intercambiarRecursos(IntercambioRecursosDTO intercambioDeRecursos) {
		Hospitais hospital1 = hospitalRepository.findByCNPJ(intercambioDeRecursos.getCnpjHospital1()).get();
		Hospitais hospital2 = hospitalRepository.findByCNPJ(intercambioDeRecursos.getCnpjHospital2()).get();
		Recursos recursosHospital1 = hospital1.getRecursos();
		Recursos recursosHospital2 = hospital2.getRecursos();
		
		
		String mensagem = "Não foi possível efetuar o intercambio";
		
		
		if (Util.validarIntercambio(intercambioDeRecursos, hospital1, hospital2)) {
			recursosHospital1.setQuantidadeDeAmbulancia(recursosHospital1.getQuantidadeDeAmbulancia()-intercambioDeRecursos.getQuantidadeDeAmbulanciaHospital1());
			recursosHospital1.setQuantidadeDeEnfermeiros(recursosHospital1.getQuantidadeDeEnfermeiros()-intercambioDeRecursos.getQuantidadeDeEnfermeirosHospital1());
			recursosHospital1.setQuantidadeDeMedicos(recursosHospital1.getQuantidadeDeMedicos()-intercambioDeRecursos.getQuantidadeDeMedicosHospital1());
			recursosHospital1.setQuantidadeDeRespiradores(recursosHospital1.getQuantidadeDeRespiradores()-intercambioDeRecursos.getQuantidadeDeRespiradoresHospital1());
			recursosHospital1.setQuantidadeDeTomografos(recursosHospital1.getQuantidadeDeRespiradores()-intercambioDeRecursos.getQuantidadeDeTomografosHospital1());
			
			recursosHospital2.setQuantidadeDeAmbulancia(recursosHospital2.getQuantidadeDeAmbulancia()-intercambioDeRecursos.getQuantidadeDeAmbulanciaHospital2());
			recursosHospital2.setQuantidadeDeEnfermeiros(recursosHospital2.getQuantidadeDeEnfermeiros()-intercambioDeRecursos.getQuantidadeDeEnfermeirosHospital2());
			recursosHospital2.setQuantidadeDeMedicos(recursosHospital2.getQuantidadeDeMedicos()-intercambioDeRecursos.getQuantidadeDeMedicosHospital2());
			recursosHospital2.setQuantidadeDeRespiradores(recursosHospital2.getQuantidadeDeRespiradores()-intercambioDeRecursos.getQuantidadeDeRespiradoresHospital2());
			recursosHospital2.setQuantidadeDeTomografos(recursosHospital2.getQuantidadeDeTomografos()-intercambioDeRecursos.getQuantidadeDeTomografosHospital2());
			
			recursosHospital1.setQuantidadeDeAmbulancia(recursosHospital1.getQuantidadeDeAmbulancia()+ intercambioDeRecursos.getQuantidadeDeAmbulanciaHospital2());
			recursosHospital1.setQuantidadeDeEnfermeiros(recursosHospital1.getQuantidadeDeEnfermeiros()+ intercambioDeRecursos.getQuantidadeDeEnfermeirosHospital2());
			recursosHospital1.setQuantidadeDeMedicos(recursosHospital1.getQuantidadeDeMedicos()-intercambioDeRecursos.getQuantidadeDeMedicosHospital2());
			recursosHospital1.setQuantidadeDeRespiradores(recursosHospital1.getQuantidadeDeRespiradores()+ intercambioDeRecursos.getQuantidadeDeRespiradoresHospital2());
			recursosHospital1.setQuantidadeDeTomografos(recursosHospital1.getQuantidadeDeRespiradores()+intercambioDeRecursos.getQuantidadeDeTomografosHospital2());
			
			recursosHospital2.setQuantidadeDeAmbulancia(recursosHospital2.getQuantidadeDeAmbulancia()+intercambioDeRecursos.getQuantidadeDeAmbulanciaHospital1());
			recursosHospital2.setQuantidadeDeEnfermeiros(recursosHospital2.getQuantidadeDeEnfermeiros()+intercambioDeRecursos.getQuantidadeDeEnfermeirosHospital1());
			recursosHospital2.setQuantidadeDeMedicos(recursosHospital2.getQuantidadeDeMedicos()-intercambioDeRecursos.getQuantidadeDeMedicosHospital1());
			recursosHospital2.setQuantidadeDeRespiradores(recursosHospital2.getQuantidadeDeRespiradores()+intercambioDeRecursos.getQuantidadeDeRespiradoresHospital1());
			recursosHospital2.setQuantidadeDeTomografos(recursosHospital2.getQuantidadeDeTomografos()+intercambioDeRecursos.getQuantidadeDeTomografosHospital1());
			
			hospitalRepository.save(hospital1);
			hospitalRepository.save(hospital2);
			
			IntercambioDeRecursos intercambio = new IntercambioDeRecursos(hospital1.getNome(), hospital2.getNome(), intercambioDeRecursos);
			intercambioRepository.save(intercambio);
			
			
			mensagem = "intercambio de recursos efetuado com sucesso";
		}
		return mensagem;
	}

	
	/*
	 * gera um relatorio de intercambio
	 */
	@Override
	public String getRelatórioDeIntercambios() {
		List<IntercambioDeRecursos> intercambios = intercambioRepository.findAll();
		String relatorio = "";
		
		if (intercambios.size()==0) {
			relatorio += "Nenhuma transação de intercambio encontrada";
		} else {
			for (IntercambioDeRecursos i: intercambios) {
				relatorio += i.toString();
			}
		}
		
		return relatorio;
	}

}

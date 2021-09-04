package com.pandemiccombat.pandemiccombat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Recursos;
import com.pandemiccombat.pandemiccombat.repository.RecursosRepository;

/*
 * classe de implementação lógica do sistema
 */
@Service
public class RecursosServiceImpl implements RecursosService {

	/*
	 * recursosRepository é utilizado para persistir os dados no banco de dados a partir do jpa
	 */
	@Autowired
	RecursosRepository recursosRepository;
	
	/*
	 * cria Recursos para ser adicionado a um hospital
	 */
	@Override
	public Recursos criaRecursos(HospitalDTO hospitalDTO) {
		Recursos recursos = new Recursos(hospitalDTO.getQuantidadeDeAmbulancia(), hospitalDTO.getQuantidadeDeEnfermeiros(),
				hospitalDTO.getQuantidadeDeMedicos(), hospitalDTO.getQuantidadeDeRespiradores(), hospitalDTO.getQuantidadeDeTomografos());
		return recursos;
	}

	/*
	 * salva os recursos criados no banco de dados
	 */
	@Override
	public void salvarRecursos(Recursos recursos) {
		recursosRepository.save(recursos);
		
	}

	/*
	 * retorna um relatório com uma quantidade média de recursos por hospital
	 */
	@Override
	public String getRelatorioDeRecursos() {
		String relatorio = "A quantidade média de cada tipo de recurso por hospital é de:\n";
		Integer quantidadeDeAmbulancia = 0;
		Integer quantidadeDeEnfermeiros= 0;
		Integer quantidadeDeMedicos= 0;
		Integer quantidadeDeRespiradores= 0;
		Integer quantidadeDeTomografos= 0;
		
		List<Recursos> recursos = recursosRepository.findAll();
		Integer quantidadeDeRecursos = recursos.size();
		
		if (recursos.size()>0) {
			for (Recursos r: recursos) {
				quantidadeDeAmbulancia += r.getQuantidadeDeAmbulancia();
				quantidadeDeEnfermeiros += r.getQuantidadeDeEnfermeiros();
				quantidadeDeMedicos += r.getQuantidadeDeMedicos();
				quantidadeDeRespiradores += r.getQuantidadeDeRespiradores();
				quantidadeDeTomografos += r.getQuantidadeDeTomografos();
			}
			
			
		}
		relatorio += "a quantidade média de ambulâncias por hospital é de: "+(quantidadeDeAmbulancia/quantidadeDeRecursos)+"\n";
		relatorio += "a quantidade média de enfermeiros por hospital é de: "+(quantidadeDeEnfermeiros/quantidadeDeRecursos)+"\n";
		relatorio += "a quantidade média de médicos por hospital é de: "+(quantidadeDeMedicos/quantidadeDeRecursos)+"\n";
		relatorio += "a quantidade média de respiradores por hospital é de: "+(quantidadeDeRespiradores/quantidadeDeRecursos)+"\n";
		relatorio += "a quantidade média de tomógrafos por hospital é de: "+(quantidadeDeTomografos/quantidadeDeRecursos)+"\n";
		
		
		return relatorio;
	}

}

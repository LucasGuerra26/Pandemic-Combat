package com.pandemiccombat.pandemiccombat.service;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Recursos;

/*
 * interface de controle
 */
public interface RecursosService {
	
	/*
	 * cria Recursos para ser adicionado a um hospital
	 */
	public Recursos criaRecursos (HospitalDTO hospitalDTO);
	
	/*
	 * salva os recursos criados no banco de dados
	 */
	public void salvarRecursos(Recursos recursos);
	
	/*
	 * retorna um relatório com uma quantidade média de recursos por hospital
	 */
	public String getRelatorioDeRecursos();

}

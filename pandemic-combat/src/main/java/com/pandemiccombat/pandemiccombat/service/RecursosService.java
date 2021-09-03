package com.pandemiccombat.pandemiccombat.service;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Recursos;

public interface RecursosService {
	public Recursos criaRecursos (HospitalDTO hospitalDTO);
	public void salvarRecursos(Recursos recursos);

}

package com.pandemiccombat.pandemiccombat.service;

import com.pandemiccombat.pandemiccombat.DTO.IntercambioRecursosDTO;

public interface IntercambioService {

	public String intercambiarRecursos(IntercambioRecursosDTO intercambioDeRecursos);
	public String getRelatórioDeIntercambios();
}

package com.pandemiccombat.pandemiccombat.util;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.DTO.IntercambioRecursosDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
import com.pandemiccombat.pandemiccombat.model.IntercambioDeRecursos;

public class Util {

	/*
	 * verifica se a pontuação referente aos recursos para intercambio são iguais, se não forem verifica se algum dos hospitais
	 * está com ocupação maior igual a 90 para que possa autorizar o intercambio.
	 */
	public static boolean validarIntercambio(IntercambioRecursosDTO iR, Hospitais h1, Hospitais h2){
		int pontosHospital1 = (10*iR.getQuantidadeDeAmbulanciaHospital1())+(3*iR.getQuantidadeDeEnfermeirosHospital1())+(3*iR.getQuantidadeDeMedicosHospital1())+(5*iR.getQuantidadeDeRespiradoresHospital1())+(12*iR.getQuantidadeDeTomografosHospital1());
		int pontosHospital2 = (10*iR.getQuantidadeDeAmbulanciaHospital2())+(3*iR.getQuantidadeDeEnfermeirosHospital2())+(3*iR.getQuantidadeDeMedicosHospital2())+(5*iR.getQuantidadeDeRespiradoresHospital2())+(12*iR.getQuantidadeDeTomografosHospital2());
		
		if (pontosHospital1 == pontosHospital2) {
			return true;
		}else if (pontosHospital1<pontosHospital2 && h1.getOcupacao()>=90 && h2.getOcupacao()<90 ){
			return true;
		} else if (pontosHospital2<pontosHospital1 && h2.getOcupacao()>=90 && h1.getOcupacao()<90) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean podeAdicionarHospital(HospitalDTO hospitalDTO) {
		
		if ((hospitalDTO.getEndereco().equals("") || hospitalDTO.getLocalizacao().equals("") || hospitalDTO.getNome().equals(""))) {
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean validaCNPJ(HospitalDTO hospitalDTO) {
		if ((""+hospitalDTO.getCnpj()).length()==14) {
			return true;
		} else {
			return false;
		}
	}
}

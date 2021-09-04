package com.pandemiccombat.pandemiccombat.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pandemiccombat.pandemiccombat.DTO.IntercambioRecursosDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
import com.pandemiccombat.pandemiccombat.service.HospitalService;
import com.pandemiccombat.pandemiccombat.service.IntercambioService;
import com.pandemiccombat.pandemiccombat.service.RecursosService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RecursosController {

	/*
	 * recursosService é a classe que manipula todos os dados do sistema e do banco de dados no que se refere aos
	 * recursos dos hospitais
	 */
	@Autowired
	RecursosService recursosService;
	
	/*
	 * hospitalService é a classe que manipula todos os dados do sistema e do banco de dados no que se refere aos
	 * hospitais
	 */
	@Autowired
	HospitalService hospitalService;
	
	/*
	 * intercambioService é a classe que manipula todos os dados do sistema e do banco de dados no que se refere aos
	 * intercambios
	 */
	@Autowired
	IntercambioService intercambioService;
	
	
	/*
	 * relatorioDeRecursos este método retorna um relatório com a quantidade média de recursos por hospital
	 */
	@RequestMapping(value = "/numero-de-recursos-por-hospital", method = RequestMethod.GET)
	public ResponseEntity<?> relatorioDeRecursos(){
		String relatorio = recursosService.getRelatorioDeRecursos();
		
		return new ResponseEntity<String>(relatorio, HttpStatus.OK);
	}
	
	/*
	 * intercambio de recursos entre hospitais, esta função realiza a troca de aparelhos ou funcionários entre um
	 * hospital e outro
	 */
	@RequestMapping(value = "/intercambiar-recursos", method = RequestMethod.PUT)
	public ResponseEntity<?> intercambiarRecursos(@RequestBody IntercambioRecursosDTO intercambioDeRecursos){
		Optional<Hospitais> hospital1OP = hospitalService.getHospitalByCNPJ(intercambioDeRecursos.getCnpjHospital1());
		Optional<Hospitais> hospital2OP = hospitalService.getHospitalByCNPJ(intercambioDeRecursos.getCnpjHospital2());
		
		if (hospital1OP.isEmpty()) {return new ResponseEntity<String>("Hospital 1 não encontrado", HttpStatus.OK);}
		if (hospital2OP.isEmpty()) {return new ResponseEntity<String>("Hospital 2 não encontrado", HttpStatus.OK);}
		
		String resultadoDaOperacao = intercambioService.intercambiarRecursos(intercambioDeRecursos);
		
		return new ResponseEntity<String>(resultadoDaOperacao, HttpStatus.OK);
	}
	
	/*
	 * relatorioDeIntercambio este método retorna um relatório com o histórico de intercambios realizados pelos hospitais
	 * do sistema
	 */
	@RequestMapping(value = "/relatorio-de-intercambio-de-recursos", method = RequestMethod.PUT)
	public ResponseEntity<?> relatorioDeIntercambio(){
		
		String relatorio = "HISTÓRIOCO DE INTERCAMBIOS:\n";
		
		relatorio+= intercambioService.getRelatórioDeIntercambios();
		
		return new ResponseEntity<String>(relatorio, HttpStatus.OK);
	}
	
}

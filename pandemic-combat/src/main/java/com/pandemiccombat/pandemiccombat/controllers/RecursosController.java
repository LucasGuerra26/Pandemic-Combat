package com.pandemiccombat.pandemiccombat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	 * relatorioDeRecursos este método retorna um relatório com a quantidade média de recursos por hospital
	 */
	@RequestMapping(value = "/numero-de-recursos-por-hospital", method = RequestMethod.GET)
	public ResponseEntity<?> relatorioDeRecursos(){
		String relatorio = recursosService.getRelatorioDeRecursos();
		
		return new ResponseEntity<String>(relatorio, HttpStatus.OK);
	}
}

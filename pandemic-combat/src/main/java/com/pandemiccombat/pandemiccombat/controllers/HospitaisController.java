package com.pandemiccombat.pandemiccombat.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
import com.pandemiccombat.pandemiccombat.model.Recursos;
import com.pandemiccombat.pandemiccombat.service.HospitalService;
import com.pandemiccombat.pandemiccombat.service.RecursosService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HospitaisController {
	
	@Autowired
	HospitalService hospitalService;
	@Autowired
	RecursosService recursosService;

	@RequestMapping(value = "/adiciona-Hospital", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarHospital(@RequestBody HospitalDTO hospitalDTO, UriComponentsBuilder ucBuilder) {

		Optional<Hospitais> hospitalOp = hospitalService.getHospitalByCNPJ(hospitalDTO.getCnpj());
		if (!hospitalOp.isEmpty()) {
			return new ResponseEntity<>("O hospital com esse CNPJ já está cadastrado",HttpStatus.CONFLICT);
		}

		Hospitais hospital = hospitalService.criaHospital(hospitalDTO);
		Recursos recursos = recursosService.criaRecursos(hospitalDTO);
		recursosService.salvarRecursos(recursos);
		hospitalService.atualizaRecursos(recursos, hospital);
		hospitalService.salvarHospitalCadastrado(hospital);

		return new ResponseEntity<Hospitais>(hospital, HttpStatus.CREATED);
	}
	

	@RequestMapping(value = "/atualizar-Percentual-Ocupacao/{cnpj}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizarPercentualDeOcupacao(@PathVariable("cnpj") long cnpj, @RequestParam int ocupacao) {

		Optional<Hospitais> hospitalOp = hospitalService.getHospitalByCNPJ(cnpj);
		if (hospitalOp.isEmpty()) {
			return new ResponseEntity<>("O hospital não encontrado no banco de dados",HttpStatus.OK);
		}

		Hospitais hospital = hospitalOp.get();
		hospitalService.alteraOcupacao(hospital, ocupacao);
		hospitalService.salvarHospitalCadastrado(hospital);

		return new ResponseEntity<String>( "alterado", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/PercentualDeHospitaisComOcupacaoMaiorQue90", method = RequestMethod.GET)
	public ResponseEntity<?> relatorioMaiorQueNoventa(){
		String relatorio = "A porcentagem de hospitais com ocupação superior a 90% é de:\n";
		String porcentagem = hospitalService.getRelatorioOcupacaoMaiorNoventa();
		
		return new ResponseEntity<String>(relatorio+porcentagem, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/PercentualDeHospitaisComOcupacaoMenorQue90", method = RequestMethod.GET)
	public ResponseEntity<?> relatorioMenorQueNoventa(){
		String relatorio = "A porcentagem de hospitais com ocupação inferior a 90% é de:\n";
		String porcentagem = hospitalService.getRelatorioOcupacaoMenorNoventa();
		
		return new ResponseEntity<String>(relatorio+porcentagem, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/HospitalComOcupacaoMaiorQue90MaisAntigo", method = RequestMethod.GET)
	public ResponseEntity<?> hospitalOcupacaoMaiorQueNoventaMaisAntigo(){
		List<Hospitais> hospitais = hospitalService.getHospitalAMaisTempoComAltaOcupacao();
		if (hospitais.size()==0) {
			return new ResponseEntity<>("Nenhum Hospital com alta ocupacao encontrado",HttpStatus.OK);
		}
		
		Hospitais hospital = hospitais.get(0);
		return new ResponseEntity<Hospitais>(hospital, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/HospitalComOcupacaoMenorQue90MaisAntigo", method = RequestMethod.GET)
	public ResponseEntity<?> hospitalOcupacaoMenorQueNoventaMaisAntigo(){
		List<Hospitais> hospitais = hospitalService.getHospitalAMaisTempoComBaixaOcupacao();
		if (hospitais.size()==0) {
			return new ResponseEntity<>("Nenhum Hospital com baixa ocupacao encontrado",HttpStatus.OK);
		}
		
		Hospitais hospital = hospitais.get(0);
		return new ResponseEntity<Hospitais>(hospital, HttpStatus.OK);
	}
}

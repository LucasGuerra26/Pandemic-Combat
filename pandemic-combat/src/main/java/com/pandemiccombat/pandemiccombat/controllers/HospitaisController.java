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

import com.pandemiccombat.pandemiccombat.DTO.HospitalDTO;
import com.pandemiccombat.pandemiccombat.model.Hospitais;
import com.pandemiccombat.pandemiccombat.service.HospitalService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HospitaisController {
	
	@Autowired
	HospitalService hospitalService;

	@RequestMapping(value = "/adicionaHospital", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarHospital(@RequestBody HospitalDTO hospitalDTO, UriComponentsBuilder ucBuilder) {

		Optional<Hospitais> hospitalop = hospitalService.getHospitalByCNPJ(hospitalDTO.getCnpj());
		if (!hospitalop.isEmpty()) {
			return new ResponseEntity<>("O hospital com esse CNPJ já está cadastrado",HttpStatus.CONFLICT);
		}

		Hospitais hospital = hospitalService.criaHospital(hospitalDTO);
		hospitalService.salvarHospitalCadastrado(hospital);

		return new ResponseEntity<Hospitais>(hospital, HttpStatus.CREATED);
	}
}

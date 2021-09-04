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
	/*
	 * hospitalService é a classe que manipula todos os dados do sistema e do banco de dados no que se refere aos
	 * hospitais
	 */
	@Autowired
	HospitalService hospitalService;
	
	/*
	 * recursosService é a classe que manipula todos os dados do sistema e do banco de dados no que se refere aos
	 * recursos dos hospitais
	 */
	@Autowired
	RecursosService recursosService;

	/*
	 * adicionarHospital adiciona um hospital ao sistema, recebe como parametro um json com as informações necessárias
	 * não só para o hospital ser adicionado mas também as informações necessárias para criar um objeto Recursos, que
	 * contém todos os recursos disponíveis do hospital, antes de iniciar o processo de adição de um novo hospital é 
	 * verificado se já existe um hospital com o cnpj informado json cadastrado no sistema, se existir, uma mensagem
	 * de erro será retornada
	*/
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
	

	/*
	 * atualizarPercentualDeOcupacao atualiza o percentual de ocupação de um determinado hospital do sistema, o método
	 * recebe como parametro o cnpj do hospital e sua nova ocupação, assim faz-se uma consulta ao banco de dados 
	 * buscando o hospital pelo seu cnpj, verifica-se se esse hospital está cadastrado, se estiver, efetua a atualização
	 */
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
	
	/*
	 * relatorioMaiorQueNoventa este método retorna um relatório com a porcentagem de hospitais que estão com sua
	 * ocupação maior ou igual a 90%
	 */
	@RequestMapping(value = "/percentual-deHospitais-com-ocupacao-maior-que-90", method = RequestMethod.GET)
	public ResponseEntity<?> relatorioMaiorQueNoventa(){
		String relatorio = "A porcentagem de hospitais com ocupação superior a 90% é de:\n";
		String porcentagem = hospitalService.getRelatorioOcupacaoMaiorNoventa();
		
		return new ResponseEntity<String>(relatorio+porcentagem, HttpStatus.OK);
	}
	
	/*
	 * relatorioMenorQueNoventa este método retorna um relatório com a porcentagem de hospitais que estão com sua
	 * ocupação menor que 90%
	 */
	@RequestMapping(value = "/percentual-de-hospitais-com-ocupacao-menor-que-90", method = RequestMethod.GET)
	public ResponseEntity<?> relatorioMenorQueNoventa(){
		String relatorio = "A porcentagem de hospitais com ocupação inferior a 90% é de:\n";
		String porcentagem = hospitalService.getRelatorioOcupacaoMenorNoventa();
		
		return new ResponseEntity<String>(relatorio+porcentagem, HttpStatus.OK);
	}
	
	/*
	 * hospitalOcupacaoMaiorQueNoventaMaisAntigo este método retorna o hospital que está com alta ocupação a mais tempo.
	 * em caso de não existir nenhum hospital com alta ocupação uma mensagem será exibida informado que não tem nenhum
	 * hospital com alta ocupacao no sistema
	 */
	@RequestMapping(value = "/hospital-com-ocupacao-maior-que-90-a-mais-tempo", method = RequestMethod.GET)
	public ResponseEntity<?> hospitalOcupacaoMaiorQueNoventaMaisAntigo(){
		List<Hospitais> hospitais = hospitalService.getHospitalAMaisTempoComAltaOcupacao();
		if (hospitais.size()==0) {
			return new ResponseEntity<>("Nenhum Hospital com alta ocupacao encontrado",HttpStatus.OK);
		}
		
		Hospitais hospital = hospitais.get(0);
		return new ResponseEntity<Hospitais>(hospital, HttpStatus.OK);
	}
	
	/*
	 * hospitalOcupacaoMenorQueNoventaMaisAntigo este método retorna o hospital que está com baixa ocupação a mais tempo.
	 * em caso de não existir nenhum hospital com baixa ocupação uma mensagem será exibida informado que não tem nenhum
	 * hospital com baixa ocupacao no sistema
	 */
	@RequestMapping(value = "/hospital-com-ocupacao-menor-que-90-a-mais-tempo", method = RequestMethod.GET)
	public ResponseEntity<?> hospitalOcupacaoMenorQueNoventaMaisAntigo(){
		List<Hospitais> hospitais = hospitalService.getHospitalAMaisTempoComBaixaOcupacao();
		if (hospitais.size()==0) {
			return new ResponseEntity<>("Nenhum Hospital com baixa ocupacao encontrado",HttpStatus.OK);
		}
		
		Hospitais hospital = hospitais.get(0);
		return new ResponseEntity<Hospitais>(hospital, HttpStatus.OK);
	}
	
}

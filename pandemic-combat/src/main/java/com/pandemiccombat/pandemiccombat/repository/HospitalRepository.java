package com.pandemiccombat.pandemiccombat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pandemiccombat.pandemiccombat.model.Hospitais;

/*
 * interface de controle do banco de dados via jpa
 */
@Repository
public interface HospitalRepository extends JpaRepository<Hospitais, Long> {

	/*
	 * faz uma consulta no banco de dados a partir do cnpj de um hospital
	 */
	Optional<Hospitais> findByCNPJ(long cnpj);
	
	/*
	 * faz uma consulta no banco de dados e retorna uma lista com os hospitais com ocupacao maior ou igual a 90
	 */
	@Query(value="SELECT * from HOSPITAIS where OCUPACAO >=90", nativeQuery = true)
	List<Hospitais> buscarHospitaisComOcupacaoSuperiorANoventa();
	
	/*
	 * faz uma consulta no banco de dados e retorna uma lista com os hospitais com ocupacao menor que 90
	 */
	@Query(value="SELECT * from HOSPITAIS where OCUPACAO <90", nativeQuery = true)
	List<Hospitais> buscarHospitaisComOcupacaoInferiorANoventa();
	
	/*
	 * faz uma consulta no banco de dados e retorna uma lista com os hospitais com ocupacao maior ou igual a 90
	 * essa consulta trás a lista ordenada da data mais antiga para a mais atual, usado para pegar o hospital
	 * com mais tempo em alta ocupação
	 */
	@Query(value="SELECT *,MIN(DATA_DE_CONTROLE_DE_OCUPACAO) from HOSPITAIS where OCUPACAO >=90 GROUP BY DATA_DE_CONTROLE_DE_OCUPACAO", nativeQuery = true)
	List<Hospitais> buscarHospitalMaisAntigoComOcupacaoSuperiorANoventa();
	
	/*
	 * faz uma consulta no banco de dados e retorna uma lista com os hospitais com ocupacao menor que 90
	 * essa consulta trás a lista ordenada da data mais antiga para a mais atual, usado para pegar o hospital
	 * com mais tempo em baixa ocupação
	 */
	@Query(value="SELECT *,MIN(DATA_DE_CONTROLE_DE_OCUPACAO) from HOSPITAIS where OCUPACAO < 90 GROUP BY DATA_DE_CONTROLE_DE_OCUPACAO", nativeQuery = true)
	List<Hospitais> buscarHospitalMaisAntigoComOcupacaoInferiorANoventa();
}

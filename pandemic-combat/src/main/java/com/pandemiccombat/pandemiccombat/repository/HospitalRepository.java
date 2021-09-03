package com.pandemiccombat.pandemiccombat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pandemiccombat.pandemiccombat.model.Hospitais;

@Repository
public interface HospitalRepository extends JpaRepository<Hospitais, Long> {

	Optional<Hospitais> findByCNPJ(long cnpj);
	
	@Query(value="SELECT * from HOSPITAIS where OCUPACAO >=90", nativeQuery = true)
	List<Hospitais> buscarHospitaisComOcupacaoSuperiorANoventa();
	
	@Query(value="SELECT * from HOSPITAIS where OCUPACAO <90", nativeQuery = true)
	List<Hospitais> buscarHospitaisComOcupacaoInferiorANoventa();
	
	@Query(value="SELECT *,MIN(DATA_DE_CONTROLE_DE_OCUPACAO) from HOSPITAIS where OCUPACAO >=90 GROUP BY DATA_DE_CONTROLE_DE_OCUPACAO", nativeQuery = true)
	List<Hospitais> buscarHospitalMaisAntigoComOcupacaoSuperiorANoventa();
	
	@Query(value="SELECT *,MIN(DATA_DE_CONTROLE_DE_OCUPACAO) from HOSPITAIS where OCUPACAO < 90 GROUP BY DATA_DE_CONTROLE_DE_OCUPACAO", nativeQuery = true)
	List<Hospitais> buscarHospitalMaisAntigoComOcupacaoInferiorANoventa();
}

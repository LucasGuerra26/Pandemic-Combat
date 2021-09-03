package com.pandemiccombat.pandemiccombat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemiccombat.pandemiccombat.model.Hospitais;

public interface HospitalRepository extends JpaRepository<Hospitais, Long> {

	Optional<Hospitais> findByCNPJ(long cnpj);
}

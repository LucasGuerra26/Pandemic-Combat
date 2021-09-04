package com.pandemiccombat.pandemiccombat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemiccombat.pandemiccombat.model.Recursos;

/*
 * interface de controle do banco de dados via jpa
 */
public interface RecursosRepository extends JpaRepository<Recursos, Long>{

}

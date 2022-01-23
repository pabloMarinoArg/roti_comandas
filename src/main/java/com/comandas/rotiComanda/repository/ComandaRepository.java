package com.comandas.rotiComanda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comandas.rotiComanda.entity.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {

	
	
}

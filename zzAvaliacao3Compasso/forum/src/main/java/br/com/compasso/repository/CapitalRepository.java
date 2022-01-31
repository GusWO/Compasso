package br.com.compasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.modelo.Capital;

public interface CapitalRepository extends JpaRepository<Capital, Long>{

	Capital findByNome(String nome);
}

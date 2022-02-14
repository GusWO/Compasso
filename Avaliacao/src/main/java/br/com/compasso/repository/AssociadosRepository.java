package br.com.compasso.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.modelo.Associado;

public interface AssociadosRepository extends JpaRepository<Associado, Long>{

	Associado findByNome(String nome);
	Optional<Associado> findById(Long id);
	void deleteById(Long id);
	Page<Associado> findByNome(String nome, Pageable paginacao);
	
	
}

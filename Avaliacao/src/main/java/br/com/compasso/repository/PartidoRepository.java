package br.com.compasso.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.modelo.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long>{

	
	Page<Partido> findByNome(String nome, Pageable paginacao);
	Partido findByNome(String nome);
	void deleteById(Long id);
}

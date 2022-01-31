package br.com.compasso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	List<Estado> findByEstadoNome(String nomeEstado);
	
}

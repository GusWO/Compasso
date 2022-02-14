package br.com.compasso.controller.form;

import java.util.Optional;

import br.com.compasso.modelo.Partido;
import br.com.compasso.repository.PartidoRepository;

public class AtualizaPartidoForm {

	private String nome;
	private String sigla;
	private String ideologia;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}

	public Partido atualizar(Long id, PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.getOne(id);
		
		partido.setNome(nome);
		partido.setSigla(sigla);
		partido.setIdeologia(ideologia);
		
		return partido;
	}
	
	

}

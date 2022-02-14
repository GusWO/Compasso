package br.com.compasso.controller.form;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.modelo.Associado;
import br.com.compasso.modelo.Partido;
import br.com.compasso.repository.PartidoRepository;

public class PartidoForm {

	@NotEmpty
	@NotNull
	private String nome;
	@NotEmpty
	@NotNull
	private String sigla;
	@NotEmpty
	@NotNull
	private String ideologia;
	@NotEmpty
	@NotNull
	private LocalDate dataCriacao;
	@NotEmpty
	@NotNull
	private List<Associado> associados;
	
	private PartidoRepository partidoRepository;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Associado> getAssociados() {
		return associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}

	public PartidoRepository getPartidoRepository() {
		return partidoRepository;
	}

	public void setPartidoRepository(PartidoRepository partidoRepository) {
		this.partidoRepository = partidoRepository;
	}

	public Partido converter(PartidoRepository partidoRepository2) {
		Partido partido = partidoRepository.findByNome(nome);
		
		return new Partido(nome, sigla, ideologia, partido);
	}
	
	
}

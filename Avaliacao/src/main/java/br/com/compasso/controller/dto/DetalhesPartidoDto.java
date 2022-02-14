package br.com.compasso.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.compasso.modelo.Associado;
import br.com.compasso.modelo.Partido;

public class DetalhesPartidoDto {

	private Long id;
	private String nome;
	private String sigla;
	private LocalDate dataCriacao;
	private String ideologia;
	private List<Associado> associados;

	public DetalhesPartidoDto(Partido partido) {
		this.id = partido.getId();
		this.nome = partido.getNome();
		this.sigla = partido.getSigla();
		this.dataCriacao = partido.getDataFundacao();
		this.ideologia = partido.getIdeologia();
		this.associados = new ArrayList<>();
		this.associados
				.add((Associado) partido.getAssociados().stream().map(AssociadoDto::new).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public List<Associado> getAssociados() {
		return associados;
	}

}

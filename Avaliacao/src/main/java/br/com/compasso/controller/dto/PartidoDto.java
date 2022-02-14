package br.com.compasso.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.compasso.modelo.Partido;

public class PartidoDto {

	private Long id;
	private String nome;
	private String sigla;
	private LocalDate dataCriacao;
	private String ideologia;

	public PartidoDto(Partido partido) {
		this.id = partido.getId();
		this.nome = partido.getNome();
		this.sigla = partido.getSigla();
		this.dataCriacao = partido.getDataFundacao();
		this.ideologia = partido.getIdeologia();
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

	public static Page<PartidoDto> converter(Page<Partido> partido) {
		
		return partido.map(PartidoDto::new);
	}

}

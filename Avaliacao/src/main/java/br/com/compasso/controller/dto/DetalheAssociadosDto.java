package br.com.compasso.controller.dto;

import java.time.LocalDate;

import br.com.compasso.modelo.Associado;
import br.com.compasso.modelo.Partido;

public class DetalheAssociadosDto {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cargoPolitico;
	private Partido partido;

	public DetalheAssociadosDto(Associado associado) {
		this.id = associado.getId();
		this.nome = associado.getNome();
		this.dataNascimento = associado.getDataNascimento();
		this.sexo = associado.getSexo();
		this.cargoPolitico = associado.getCargoPolitico();
		this.partido = associado.getPartido();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public String getCargoPolitico() {
		return cargoPolitico;
	}

	public Partido getPartido() {
		return partido;
	}
	
	

}

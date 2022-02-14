package br.com.compasso.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.compasso.modelo.Associado;

public class AssociadoDto {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cargoPolitico;

	public AssociadoDto(Associado associado) {
		this.id = associado.getId();
		this.nome = associado.getNome();
		this.dataNascimento = associado.getDataNascimento();
		this.sexo = associado.getSexo();
		this.cargoPolitico = associado.getCargoPolitico();
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

	public static Page<AssociadoDto> converter(Page<Associado> associado) {
		
		return associado.map(AssociadoDto::new);
	}
	
	

}

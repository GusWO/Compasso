package br.com.compasso.controller.form;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.modelo.Associado;
import br.com.compasso.modelo.Partido;
import br.com.compasso.repository.AssociadosRepository;

public class AssociadoForm {

	@NotEmpty
	@NotNull
	private String nome;
	@NotEmpty
	@NotNull
	private String sexo;
	@NotEmpty
	@NotNull
	private LocalDate dataNascimento;
	@NotEmpty
	@NotNull
	private String cargoPolitico;
	@NotEmpty
	@NotNull
	private Partido partido;
	
	private AssociadosRepository associadosRepository;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCargoPolitico() {
		return cargoPolitico;
	}

	public void setCargoPolitico(String cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Associado converter(AssociadosRepository associadosRepository2) {
		Associado associado = associadosRepository.findByNome(nome);
		
		return new Associado(nome, sexo, partido, cargoPolitico, dataNascimento, associado);
		
	}

	
	
	

}























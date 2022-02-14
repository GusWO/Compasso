package br.com.compasso.modelo;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cargoPolitico;
	private LocalDate dataNascimento;
	private String sexo;
	@OneToOne
	private Partido partido;
	
	public Associado() {
		
	}
	
	public Associado(Long id, String nome, String cargoPolitico, LocalDate dataNascimento, String sexo,
			Partido partido) {
		this.nome = nome;
		this.cargoPolitico = cargoPolitico;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.partido = partido;
	}



	public Associado(@NotEmpty @NotNull String nome2, @NotEmpty @NotNull String sexo2,
			@NotEmpty @NotNull Partido partido2, @NotEmpty @NotNull String cargoPolitico2,
			@NotEmpty @NotNull LocalDate dataNascimento2, Associado associado) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargoPolitico() {
		return cargoPolitico;
	}

	public void setCargoPolitico(String cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}

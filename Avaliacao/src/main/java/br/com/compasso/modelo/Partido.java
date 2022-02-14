package br.com.compasso.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sigla;
	private LocalDate dataFundacao;
	private String ideologia;
	@OneToMany(mappedBy = "partido")
	private List<Associado> associado;

	public Partido() {
		
	}
	
	public Partido(@NotEmpty @NotNull String nome2, @NotEmpty @NotNull String sigla2,
			@NotEmpty @NotNull String ideologia2, Partido partido) {
		
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}

	public List<Associado> getAssociados() {
		return associado;
	}

	public void setAssociados(List<Associado> associado) {
		this.associado = associado;
	}

}

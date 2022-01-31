package br.com.compasso.dto;

import br.com.compasso.modelo.Estado;

public class DetalheEstadoDto {

	private Long id;
	private String nome;
	private String regiao;
	private int populacao;
	private int area;
  
	public DetalheEstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.regiao = estado.getRegiao();
		this.populacao = estado.getPopulacao();
		this.area = estado.getArea();
		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public int getPopulacao() {
		return populacao;
	}

	public int getArea() {
		return area;
	}

	

}

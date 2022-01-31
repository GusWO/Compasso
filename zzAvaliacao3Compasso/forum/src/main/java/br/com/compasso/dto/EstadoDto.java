package br.com.compasso.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.compasso.modelo.Estado;

public class EstadoDto {

	private Long id;
	private String nome;
	private String regiao;
	private int populacao;
	private int area;

	public EstadoDto(Estado estado) {

		this.id = estado.getId();
		this.nome = estado.getNome();
		this.regiao = estado.getNome();
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
	
	public static List<EstadoDto> converter(List<Estado> estados){
		
		return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
	}

}












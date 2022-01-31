package br.com.compasso.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.modelo.Estado;
import br.com.compasso.repository.EstadoRepository;

public class AtualizacaoEstadoForm {

	@NotNull
	@NotEmpty
	private int populacao;

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	
	public Estado atualizar(Long id, EstadoRepository estadoRepository) {
		
		Estado estado = estadoRepository.getOne(id);
		estado.setPopulacao(this.populacao);
		return estado;
	}

}

package br.com.compasso.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.modelo.Capital;
import br.com.compasso.modelo.Estado;
import br.com.compasso.repository.CapitalRepository;

public class EstadoForm {

	@NotEmpty @NotNull
	private String nomeCapital;

	public String getNomeCapital() {
		return nomeCapital;
	}

	public void setNomeCapital(String nomeCapital) {
		this.nomeCapital = nomeCapital;
	}
	
	public Estado converter(CapitalRepository capitalRepository) {
		Capital capital = capitalRepository.findByNome(nomeCapital);
		
		return new Estado(capital);
	}

}

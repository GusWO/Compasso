package br.com.compasso.controller.form;

import br.com.compasso.modelo.Associado;
import br.com.compasso.modelo.Partido;
import br.com.compasso.repository.AssociadosRepository;

public class AtualizaAssociadoForm {

	private String cargoPolitico;
	private Partido partido;

	public void setCargoPolitico(String cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	public Associado atualizar(Long id, AssociadosRepository associadosRepository) {
		Associado associado = associadosRepository.getOne(id);
		
		associado.setCargoPolitico(cargoPolitico);
		associado.setPartido(partido);
		return associado;
	}



}

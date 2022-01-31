package br.com.compasso.validacao;

public class FormularioDto {

	private String campo;
	private String erro;

	public FormularioDto(String campo, String erro) {
		
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}

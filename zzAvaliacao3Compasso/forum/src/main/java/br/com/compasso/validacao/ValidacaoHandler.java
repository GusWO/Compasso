package br.com.compasso.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidacaoHandler {

	@Autowired
	private MessageSource messageSource;
	
	public List<FormularioDto> handle(MethodArgumentNotValidException exception){
		
		List<FormularioDto> fdto = new ArrayList<>();
		List<FieldError> erro = exception.getBindingResult().getFieldErrors();
		erro.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			FormularioDto formulario = new FormularioDto(e.getField(), mensagem);
			fdto.add(formulario);
		});
		
		return fdto;
	}
	
}

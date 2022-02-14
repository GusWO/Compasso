package br.com.compasso.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.controller.dto.AssociadoDto;
import br.com.compasso.controller.dto.DetalheAssociadosDto;
import br.com.compasso.controller.form.AssociadoForm;
import br.com.compasso.controller.form.AtualizaAssociadoForm;
import br.com.compasso.modelo.Associado;
import br.com.compasso.repository.AssociadosRepository;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

	@Autowired
	private AssociadosRepository associadosRepository;
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeAssociados", allEntries = true)
	public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoForm form, UriComponentsBuilder uriBuilder){
		
		Associado associado = form.converter(associadosRepository);
		associadosRepository.save(associado);
		
		URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssociadoDto(associado));
		
	}
	
	@GetMapping
	@Cacheable(value = "listaDeAssociados")
	public Page<AssociadoDto> lista(@RequestParam(required = false) String nome, @PageableDefault(sort = "dataCriacao") Pageable paginacao){
		
		if(nome == null) {
			Page<Associado> associado = associadosRepository.findAll(paginacao);
			return AssociadoDto.converter(associado);
		}
		
		Page<Associado> associado = associadosRepository.findByNome(nome, paginacao);
		return AssociadoDto.converter(associado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheAssociadosDto> detalhes(@PathVariable Long id){
		Optional<Associado> associado = associadosRepository.findById(id);
		if(associado.isPresent()) {
			return ResponseEntity.ok(new DetalheAssociadosDto(associado.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@CacheEvict(value = "listaDeAssociados", allEntries = true)
	public ResponseEntity<AssociadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaAssociadoForm form){
		Optional<Associado> optional = associadosRepository.findById(id);
		if(optional.isPresent()) {
			Associado associado = form.atualizar(id, associadosRepository);
			return ResponseEntity.ok(new AssociadoDto(associado));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(value = "listaDeAssociados", allEntries = true)
	public ResponseEntity<AssociadoDto> remover(@PathVariable Long id){
		Optional<Associado> optional = associadosRepository.findById(id);
		if(optional.isPresent()) {
			associadosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}






























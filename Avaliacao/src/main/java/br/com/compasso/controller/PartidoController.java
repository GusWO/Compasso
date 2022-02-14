package br.com.compasso.controller;

import java.net.URI;
import java.util.Optional;

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

import br.com.compasso.controller.dto.DetalhesPartidoDto;
import br.com.compasso.controller.dto.PartidoDto;
import br.com.compasso.controller.form.AtualizaPartidoForm;
import br.com.compasso.controller.form.PartidoForm;
import br.com.compasso.modelo.Partido;
import br.com.compasso.repository.PartidoRepository;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

	@Autowired
	private PartidoRepository partidoRepository;
	
	@PostMapping
	@CacheEvict(value = "listaDePartidos", allEntries = true)
	public ResponseEntity<PartidoDto> cadastrar(@RequestBody @Valid PartidoForm form, UriComponentsBuilder uriBuilder){
		
		Partido partido = form.converter(partidoRepository);
		partidoRepository.save(partido);
		
		URI uri = uriBuilder.path("/partidos/{id}").buildAndExpand(partido.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new PartidoDto(partido));
	}
	
	@GetMapping
	@Cacheable(value = "listaDePartidos")
	public Page<PartidoDto> lista(@RequestParam(required = false) String nome, @PageableDefault(sort = "dataCriacao") Pageable paginacao){
		if(nome == null) {
			
			Page<Partido> partido = partidoRepository.findAll(paginacao);
			return PartidoDto.converter(partido);
		}
		Page<Partido> partido = partidoRepository.findByNome(nome, paginacao);
		return PartidoDto.converter(partido);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesPartidoDto> detalhes(@PathVariable Long id){
		Optional<Partido> partido = partidoRepository.findById(id);
		if(partido.isPresent()) {
			return ResponseEntity.ok(new DetalhesPartidoDto(partido.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@CacheEvict(value = "listaDePartidos", allEntries = true)
	public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaPartidoForm form){
		
		Optional<Partido> optional = partidoRepository.findById(id);
		if(optional.isPresent()) {
			
			Partido partido = form.atualizar(id, partidoRepository);
			return ResponseEntity.ok(new PartidoDto(partido));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(value = "listaDePartidos", allEntries = true)
	public ResponseEntity<PartidoDto> remover(@PathVariable Long id){
		Optional<Partido> optional = partidoRepository.findById(id);
		if(optional.isPresent()) {
			partidoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
} 






























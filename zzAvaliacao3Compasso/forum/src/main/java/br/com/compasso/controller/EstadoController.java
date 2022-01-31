package br.com.compasso.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.dto.DetalheEstadoDto;
import br.com.compasso.dto.EstadoDto;
import br.com.compasso.form.AtualizacaoEstadoForm;
import br.com.compasso.form.EstadoForm;
import br.com.compasso.modelo.Estado;
import br.com.compasso.repository.CapitalRepository;
import br.com.compasso.repository.EstadoRepository;

@RestController
@RequestMapping("/api/states")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CapitalRepository capitalRepository;

	@GetMapping
	public List<EstadoDto> listar(String nomeEstado) {

		try {

			if (nomeEstado == null) {
				List<Estado> estados = estadoRepository.findAll();
				return EstadoDto.converter(estados);
			} else {
				List<Estado> estados = estadoRepository.findByEstadoNome(nomeEstado);
				return EstadoDto.converter(estados);
			}
		} catch (Exception e) {
		  System.out.println("Erro");
		  
		}
		return null;
	}

	@PostMapping
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form, UriComponentsBuilder uriBuilder) {
		Estado estado = form.converter(capitalRepository);
		estadoRepository.save(estado);

		URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoDto(estado));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalheEstadoDto> detalhes(@PathVariable Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if (estado.isPresent()) {
			return ResponseEntity.ok(new DetalheEstadoDto(estado.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEstadoForm form) {

		Optional<Estado> estado = estadoRepository.findById(id);
		if (estado.isPresent()) {
			Estado est = form.atualizar(id, estadoRepository);
			return ResponseEntity.ok(new EstadoDto(est));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<EstadoDto> remover(@PathVariable Long id) {

		Optional<Estado> optional = estadoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}

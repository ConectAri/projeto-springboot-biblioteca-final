package br.com.curso.bibliotecaref.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.bibliotecaref.entity.Livro;
import br.com.curso.bibliotecaref.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;

	@PostMapping
	public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
		try {
			Livro criado = repository.save(livro);
			return ResponseEntity.ok(criado);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Page<Livro>> pesquisar(
			@RequestParam(required = false) String titulo,
			@RequestParam(defaultValue = "0") Integer pagina,
			@RequestParam(defaultValue = "10") Integer qtdePorPagina) {
		try {
			Pageable pag = PageRequest.of(pagina, qtdePorPagina, 
					Sort.by("titulo").ascending());
			
			Page<Livro> retorno = null;
			if (StringUtils.hasText(titulo)) {
				retorno = repository.findByTituloContaining(titulo, pag);
			} else {
				retorno = repository.findAll(pag);
			}
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
		try {
			Optional<Livro> optLivro = repository.findById(id);
			if (optLivro.isPresent()) {
				return ResponseEntity.ok(optLivro.get());	
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}

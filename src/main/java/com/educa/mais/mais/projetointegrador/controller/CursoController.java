package com.educa.mais.mais.projetointegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educa.mais.mais.projetointegrador.model.Curso;
import com.educa.mais.mais.projetointegrador.repository.CursoRepository;

@RestController
@RequestMapping ("/curso")
@CrossOrigin("*")

public class CursoController {

	@Autowired	
	private CursoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Curso>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Curso> getById(@PathVariable long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<Curso>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping 
	public ResponseEntity<Curso> post(@Valid @RequestBody Curso curso) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curso));
	}
	
	@PutMapping
	public ResponseEntity<Curso> put(@Valid @RequestBody Curso curso) {
		return ResponseEntity.status (HttpStatus.OK).body(repository.save(curso));
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
 
}

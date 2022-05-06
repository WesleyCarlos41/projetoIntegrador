package com.educa.mais.mais.projetointegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educa.mais.mais.projetointegrador.model.Parceiros;
import com.educa.mais.mais.projetointegrador.repository.ParceirosRepository;

@RestController
@RequestMapping ("/Parceiros")
@CrossOrigin ("*")

public class ParceirosController {
	@Autowired
	private ParceirosRepository repository;
	

	@GetMapping
	public ResponseEntity<List<Parceiros>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Parceiros> getById(@PathVariable long id) {
		return repository.findById (id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<Parceiros>> getByNome (@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping 
	public ResponseEntity<Parceiros> post (@Valid @RequestBody Parceiros parceiros) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(parceiros));
	}
	
	@PutMapping 
	public ResponseEntity<Parceiros> put (@Valid @RequestBody Parceiros parceiros) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(parceiros));
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}

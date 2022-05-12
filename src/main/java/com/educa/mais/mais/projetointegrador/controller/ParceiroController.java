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

import com.educa.mais.mais.projetointegrador.model.Parceiro;
import com.educa.mais.mais.projetointegrador.repository.ParceiroRepository;

@RestController
@RequestMapping ("/Parceiros")
@CrossOrigin ("*")

public class ParceiroController {
	@Autowired
	private ParceiroRepository repository;
	

	@GetMapping
	public ResponseEntity<List<Parceiro>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Parceiro> getById(@PathVariable long id) {
		return repository.findById (id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<Parceiro>> getByNome (@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping 
	public ResponseEntity<Parceiro> post (@Valid @RequestBody Parceiro parceiro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(parceiro));
	}
	
	@PutMapping 
	public ResponseEntity<Parceiro> put (@Valid @RequestBody Parceiro parceiro) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(parceiro));
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}

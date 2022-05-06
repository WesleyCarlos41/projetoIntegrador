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

import com.educa.mais.mais.projetointegrador.model.Usuarios;
import com.educa.mais.mais.projetointegrador.repository.UsuariosRepository;


@RestController
@RequestMapping ("/Usuarios")
@CrossOrigin("*")
public class UsuariosController {

	
	

		@Autowired
		private UsuariosRepository repository;
		

		@GetMapping
		public ResponseEntity<List<Usuarios>> getAll() {
			return ResponseEntity.ok(repository.findAll());
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Usuarios> getById(@PathVariable long id) {
			return repository.findById (id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping ("/nome/{nome}")
		public ResponseEntity<List<Usuarios>> getByNome (@PathVariable String nome) {
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		}
		
		@PostMapping 
		public ResponseEntity<Usuarios> post (@Valid @RequestBody Usuarios usuario) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
		}
		
		@PutMapping 
		public ResponseEntity<Usuarios> put (@Valid @RequestBody Usuarios usuario) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
		}
		
		@DeleteMapping ("/{id}")
		public void delete (@PathVariable long id) {
			repository.deleteById(id);
		}
}

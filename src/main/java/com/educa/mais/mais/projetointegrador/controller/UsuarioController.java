package com.educa.mais.mais.projetointegrador.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educa.mais.mais.projetointegrador.model.Usuario;
import com.educa.mais.mais.projetointegrador.model.UsuarioLogin;
import com.educa.mais.mais.projetointegrador.repository.UsuarioRepository;
import com.educa.mais.mais.projetointegrador.service.UsuarioService;

@RestController
@RequestMapping ("/Usuarios")
@CrossOrigin("*")
public class UsuarioController {

		@Autowired
		private UsuarioRepository repository;
		
		@Autowired
		private UsuarioService service;
		

		@GetMapping
		public ResponseEntity<List<Usuario>> getAll() {
			return ResponseEntity.ok(repository.findAll());
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Usuario> getById(@PathVariable long id) {
			return repository.findById (id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping ("/usuario/{usuario}")
		public ResponseEntity<Optional<Usuario>> getByUsuario (@PathVariable String usuario) {
			return ResponseEntity.ok(repository.findByUsuario(usuario));
		}
		
		@PostMapping("/logar")
		public ResponseEntity<UsuarioLogin> login(@RequestBody Optional<UsuarioLogin> user) {
			return service.autenticarUsuario(user).map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}

		@PostMapping("/cadastrar")
		public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) {

			return service.cadastrarUsuario(usuario)
					.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
					.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

			
				}
		
		@PutMapping 
		public ResponseEntity<Usuario> put (@Valid @RequestBody Usuario usuario) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
		}
		
		@DeleteMapping ("/{id}")
		public void delete (@PathVariable long id) {
			repository.deleteById(id);
		}
}

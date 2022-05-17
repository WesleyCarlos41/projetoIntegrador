package com.educa.mais.mais.projetointegrador.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping ("/parceiro/{cnpj}")
	public ResponseEntity<Optional<Parceiro>> getByCnpj (@PathVariable String cnpj) {
		return ResponseEntity.ok(repository.findByCnpj(cnpj));
	}
	
	@PostMapping 
	public ResponseEntity<Parceiro> post (@Valid @RequestBody Parceiro usuarioparceiro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuarioparceiro));
	}
	
//	@PutMapping("/atualizar")
//    public ResponseEntity<Parceiro> putparceiroAtualizar(@RequestBody Parceiro parceiro) {
//
//        return UsuarioService.atualizarUsuario(parceiro)
//                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
//              .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
 //}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return repository.findById(id)
                .map(resposta -> {
                repository.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
	
}

package com.educa.mais.mais.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educa.mais.mais.projetointegrador.model.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long> {
	public List<Cursos> findAllByNomeContainingIgnoreCase(String nome);
	
	
	

}

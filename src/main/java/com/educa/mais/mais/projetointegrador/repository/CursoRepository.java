package com.educa.mais.mais.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educa.mais.mais.projetointegrador.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	public List<Curso> findAllByNomeContainingIgnoreCase(String nome);
	
	
	

}

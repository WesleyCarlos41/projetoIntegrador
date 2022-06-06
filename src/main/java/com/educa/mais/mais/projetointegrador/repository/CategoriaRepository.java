package com.educa.mais.mais.projetointegrador.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educa.mais.mais.projetointegrador.model.Categoria;

	
@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
	public List<Categoria> findBycategoriaContainingIgnoreCase(String categoria );

}

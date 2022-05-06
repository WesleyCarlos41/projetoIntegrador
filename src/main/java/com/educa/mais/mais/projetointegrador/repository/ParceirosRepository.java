package com.educa.mais.mais.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educa.mais.mais.projetointegrador.model.Parceiros;

	
@Repository
public interface ParceirosRepository  extends JpaRepository<Parceiros, Long> {
	public List<Parceiros> findAllByNomeContainingIgnoreCase(String nome );

}

package com.educa.mais.mais.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educa.mais.mais.projetointegrador.model.Parceiro;

	
@Repository
public interface ParceiroRepository  extends JpaRepository<Parceiro, Long> {
	public List<Parceiro> findAllByNomeContainingIgnoreCase(String nome );

}

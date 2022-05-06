package com.educa.mais.mais.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educa.mais.mais.projetointegrador.model.Usuarios;

@Repository
public interface UsuariosRepository  extends JpaRepository<Usuarios, Long> {
	public List<Usuarios> findAllByNomeContainingIgnoreCase(String nome );
	

}

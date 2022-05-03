package com.educa.mais.mais.projetointegrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_cursos")
public class Cursos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String modelo;
	
	@NotNull
	public String nomedocurso;
	
	@NotNull
	public String professor;
	
	@NotNull
	public int qtvagas;
	
	@NotNull
	public String duracao;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNomedocurso() {
		return nomedocurso;
	}

	public void setNomedocurso(String nomedocurso) {
		this.nomedocurso = nomedocurso;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getQtvagas() {
		return qtvagas;
	}

	public void setQtvagas(int qtvagas) {
		this.qtvagas = qtvagas;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	

	
	
}

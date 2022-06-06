package com.educa.mais.mais.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	

	@NotNull
	private String nome;
	
	@NotNull
	public String professor;
	
	@NotNull
	public int qtvagas;
	
	@NotNull
	public String duracao;
	
	@ManyToOne
	@JsonIgnoreProperties("curso")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("curso")
	private Categoria categoria;
	
	
	public Categoria getParceiro() {
		return categoria;
	}

	public void setParceiro(Categoria parceiro) {
		this.categoria = parceiro;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNomedocurso(String nome) {
		this.nome = nome;
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

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuarios(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	
	
}

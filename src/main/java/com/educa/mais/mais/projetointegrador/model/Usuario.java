package com.educa.mais.mais.projetointegrador.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String nome;
	
	@Email
	@NotNull
	public String usuario;
	
	@NotNull
	public String senha;
	
	@NotNull
	public String pronome;
	
	@NotNull
	public String foto;
	
	@NotNull
	@DateTimeFormat (pattern = "dd/mm/yyyy")
	public Date dtnascimento;
	
	@NotNull
	public String celular;
	
	@NotNull
	public String endereco;
	
	@ManyToOne
	@JsonIgnoreProperties("usuario")
	private Curso curso;
	
	@ManyToOne
	@JsonIgnoreProperties("usuario")
	private Parceiro parceiro;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPronome() {
		return pronome;
	}

	public void setPronome(String pronome) {
		this.pronome = pronome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCursos(Curso curso) {
		this.curso = curso;
	}

}

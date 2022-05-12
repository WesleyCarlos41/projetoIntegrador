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
@Table(name = "tb_parceiros" )
public class Parceiro {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private int qtdvagas;
	
	@NotNull
	private String cnpj;
	
	@NotNull
	private String descrivagas;
	
	@OneToMany(mappedBy = "parceiro", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("parceiro")
	private List<Curso> curso;
	
	@OneToMany(mappedBy = "parceiro", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("parceiro")
	private List<Usuario> usuario;
	
	//Métodos acessores e modificadores
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdvagas() {
		return qtdvagas;
	}

	public void setQtdvagas(int qtdvagas) {
		this.qtdvagas = qtdvagas;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescrivagas() {
		return descrivagas;
	}

	public void setDescrivagas(String descrivagas) {
		this.descrivagas = descrivagas;
	}
	
	public List<Curso> getCurso() {
		return curso;
	}

	public void setCursos(List<Curso> curso) {
		this.curso = curso;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
}

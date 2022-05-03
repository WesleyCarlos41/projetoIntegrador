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
@Table(name = "tb_parceiros" )
public class Parceiros {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String nome;
	
	@NotNull
	public String descricao;
	
	@NotNull
	public int qtdvagas;
	
	@NotNull
	public String cnpj;
	
	@NotNull
	public String descrivagas;

	
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


}

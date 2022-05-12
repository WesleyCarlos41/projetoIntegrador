package com.educa.mais.mais.projetointegrador.model;

public class ParceiroLogin {
	 
		private Long id;
		
		private String nome;
		
		private String descricao;
		
		private int qtdvagas;
		
		private String cnpj;
		
		private String descrivagas;
		
		private String token;

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

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
		
}

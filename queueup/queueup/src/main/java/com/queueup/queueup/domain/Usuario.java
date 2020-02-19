package com.queueup.queueup.domain;

public abstract class Usuario {

	   private String nome;
	   private String email;
	   private String tipo;
	   private String login;
	   private String senha;
	   private Integer telefone;
	   
	   
	   
	public Usuario (String nome) {
	   this.nome = nome;
	}
	   


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Integer getTelefone() {
		return telefone;
	}


	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNome() {
	   return nome;
	}

	    
	   
	   
	}

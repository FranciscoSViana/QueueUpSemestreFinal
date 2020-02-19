package com.queueup.queueup.model;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.queueup.queueup.controller.Credenciais;

@Entity
@Table(name = "tb_cliente")
public class Usuario {

	@Id
	@GeneratedValue
	private UUID idCliente;

	private String nome;

	private String email;

	@Embedded
	private Credenciais credenciais;

	private Integer telefone;

	private String cpf;

	private int idade;

	@Embedded
	private Sexo genero;

	public Usuario() {
	}

	public Usuario(String nome, String email, Credenciais credenciais, Integer telefone, String cpf, int idade,
			Sexo genero) {
		this.nome = nome;
		this.email = email;
		this.credenciais = credenciais;
		this.telefone = telefone;
		this.cpf = cpf;
		this.idade = idade;
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Credenciais getCredenciais() {
		return credenciais;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Sexo getGenero() {
		return genero;
	}

	public void setGenero(Sexo genero) {
		this.genero = genero;
	}

	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}

	public void fazerReserva() {

	}

	public void cancelarReserva() {

	}

}

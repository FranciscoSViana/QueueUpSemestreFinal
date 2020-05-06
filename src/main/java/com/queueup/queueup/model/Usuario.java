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

	private String cpf;

	private String senha;

	public Usuario() {
	}

	public Usuario(UUID idCliente, String nome, String cpf, String senha) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public UUID getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(UUID idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void fazerReserva() {

	}

	public void cancelarReserva() {

	}

}

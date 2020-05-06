package com.queueup.queueup.model;

import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.queueup.queueup.controller.Credenciais;

@Entity
@Table(name = "tb_restaurante")
public class Restaurante {

	@Id
	@GeneratedValue
	private UUID idRestaurante;
	private String nome;
	private String cnpj;
	@Embedded
	private Endereco endereco;
	private String telefoneRestaurante;
	private String senha;
	private String tipo;
	private Mesa[] capacidade;
	// @JoinColumn // depois a gente ve isso
	// private int idAvaliacao;

	public Restaurante() {
	}

	public Restaurante(UUID idRestaurante, String nome, String cnpj, Endereco endereco, String telefoneRestaurante,
			String senha, String tipo, Mesa[] capacidade) {
		super();
		this.idRestaurante = idRestaurante;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefoneRestaurante = telefoneRestaurante;
		this.senha = senha;
		this.tipo = tipo;
		this.capacidade = capacidade;
	}

	public UUID getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(UUID idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefoneRestaurante() {
		return telefoneRestaurante;
	}

	public void setTelefoneRestaurante(String telefoneRestaurante) {
		this.telefoneRestaurante = telefoneRestaurante;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Mesa[] getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Mesa[] capacidade) {
		this.capacidade = capacidade;
	}

	// Métodos
	public void cadastroMesa(int qtdLugares) {

	}

	public void removerMesa() {

	}

	public void liberarMesa() {

	}

	public void bloquearMesa() {

	}

	public void editarMesa() {

	}

}

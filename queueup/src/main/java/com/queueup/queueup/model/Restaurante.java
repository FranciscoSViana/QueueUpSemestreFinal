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
@Table(name="tb_restaurante")
public class Restaurante {

	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cnpj;
	@Embedded
	private Endereco endereco;
	private String telefoneRestaurante;
	@Embedded
	private Credenciais credenciais;
	private String tipo;
	private String email;
	private LocalTime time;
	//private Mesa[] mesa;
	@JoinColumn //depois a gente ve isso
	private int idAvaliacao;

	public Restaurante() {}

	public Restaurante(String nome, String cnpj, Endereco endereco, String telefoneRestaurante, Credenciais credenciais,
			String tipo, String email, LocalTime time, Mesa[] mesa) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefoneRestaurante = telefoneRestaurante;
		this.credenciais = credenciais;
		this.tipo = tipo;
		this.email = email;
		this.time = time;
	//	this.mesa = mesa;
	}

	// Getters and Setters

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/*public Mesa[] getMesa() {
		return mesa;
	}

	public void setMesa(Mesa[] mesa) {
		this.mesa = mesa;
	}*/

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getTelefoneRestaurante() {
		return telefoneRestaurante;
	}

	public void setTelefoneRestaurante(String telefoneRestaurante) {
		this.telefoneRestaurante = telefoneRestaurante;
	}

	public Credenciais getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}

	public String getTipo() {//tipo de comida
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalTime getTime() {//funcionamento do estabelecimento
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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

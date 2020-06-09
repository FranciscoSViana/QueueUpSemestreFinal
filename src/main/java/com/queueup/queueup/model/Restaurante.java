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
	private String cidade;
	private String estado;
	private String bairro;
	private String logradouro;
	private String numEndereco;
	private String cep;
	private String telefoneRestaurante;
	private String senha;
	private String tipo;
	private Integer capacidade;
	// @JoinColumn // depois a gente ve isso
	// private int idAvaliacao;

	public Restaurante() {
	}

	public Restaurante(UUID idRestaurante, String nome, String cnpj, String cidade, String estado, String bairro,
			String logradouro, String numEndereco, String cep, String telefoneRestaurante, String senha, String tipo,
			Fila[] capacidade) {
		super();
		this.idRestaurante = idRestaurante;
		this.nome = nome;
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numEndereco = numEndereco;
		this.cep = cep;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumEndereco() {
		return numEndereco;
	}

	public void setNumEndereco(String numEndereco) {
		this.numEndereco = numEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public Fila[] getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Fila[] capacidade) {
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

package com.queueup.queueup.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String cidade;
	private String estado;
	private String bairro;
	private String logradouro;
	private String numEndereco;
	private String cep;	

	public Endereco() {
		super();
	}

	public Endereco(String cidade, String estado, String bairro, String logradouro, String numEndereco, String cep) {
		super();
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numEndereco = numEndereco;
		this.cep = cep;
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
}

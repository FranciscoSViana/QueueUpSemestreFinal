package com.queueup.queueup.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tb_avaliacao")
public class Avaliacao {
	@Id
	@GeneratedValue
	private UUID idAvaliacao;
	private String nomeRestaurante;
	private String nomeCliente;
	private byte avaliacao;
	@JoinColumn //depois vê
	private int idCliente;
	
	public Avaliacao() {}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public byte getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(byte avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	
}

package com.queueup.queueup.utils;

import java.util.UUID;

public class FilaCliente {
	private String idCliente;
	private String idRestaurante;
	private int posicao;
	
	public FilaCliente() {
	}
	
	public FilaCliente(String idCliente, String idRestaurante, int posicao) {
		this.idCliente = idCliente;
		this.idRestaurante = idRestaurante;
		this.posicao = posicao;
	}


	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public String getIdRestaurante() {
		return idRestaurante;
	}


	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}


	public int getPosicao() {
		return posicao;
	}


	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}

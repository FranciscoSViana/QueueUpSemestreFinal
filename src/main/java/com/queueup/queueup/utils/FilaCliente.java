package com.queueup.queueup.utils;


public class FilaCliente {
	private int idCliente;
	private int idRestaurante;
	private int posicao;
	
	public FilaCliente() {
	}
	
	public FilaCliente(int idCliente, int idRestaurante, int posicao) {
		this.idCliente = idCliente;
		this.idRestaurante = idRestaurante;
		this.posicao = posicao;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public int getIdRestaurante() {
		return idRestaurante;
	}


	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}


	public int getPosicao() {
		return posicao;
	}


	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}

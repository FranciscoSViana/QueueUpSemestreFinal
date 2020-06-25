package com.queueup.queueup.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fila")
public class Fila {

	@Id
	@GeneratedValue
	//private Long idFila;
	
	@Column
	private int idCliente;
	
	private int idRestaurante;
	
	private int posicao;
	
	//public static int tamanhoFila =0;
	
	public Fila() {
	}

	public Fila(int idCliente, int idRestaurante, int posicao) {
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

package com.queueup.queueup.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fila")
public class Fila {

	@Id
	@GeneratedValue
	private UUID idFila;
	
	private int idCliente;
	private int idRestaurante;
	private String qrCode;

	public Fila() {
	}

	public Fila(UUID idFila, int idCliente, int idRestaurante, String qrCode) {
		super();
		this.idFila = idFila;
		this.idCliente = idCliente;
		this.idRestaurante = idRestaurante;
		this.qrCode = qrCode;
	}

	public UUID getIdFila() {
		return idFila;
	}

	public void setIdFila(UUID idFila) {
		this.idFila = idFila;
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

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	

}

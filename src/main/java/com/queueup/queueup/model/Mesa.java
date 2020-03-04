package com.queueup.queueup.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_mesa")
public class Mesa {

	@Id
	@GeneratedValue
	private UUID idMesa;
	private int nMax;
	private int nMin;
	private boolean status_;
	private int idCliente;
	private int idRestaurante;

	public Mesa() {
	}

	public Mesa(int nMax, int nMin, boolean status_) {
		this.nMax = nMax;
		this.nMin = nMin;
		this.status_ = false;
	}

	public int getnMax() {
		return nMax;
	}

	public int getnMin() {
		return nMin;
	}

	public boolean isStatus_() {
		return status_;
	}
	
	public UUID getidMesa() {
		return idMesa;
	}

}

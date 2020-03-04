package com.queueup.queueup.domain;

public class Mesa {

	//Atriutos
	private String observacao;
	private int qtdLugares;
	private boolean ocupado;
	
	
	//Getters and Setters
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getQtdLugares() {
		return qtdLugares;
	}
	public void setQtdLugares(int qtdLugares) {
		this.qtdLugares = qtdLugares;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
}

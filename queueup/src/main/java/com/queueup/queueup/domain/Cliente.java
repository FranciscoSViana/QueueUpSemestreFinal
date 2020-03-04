package com.queueup.queueup.domain;

public class Cliente extends Usuario{

	
	public Cliente(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
		
	
	//Atributos
	private int cpf;
	private int idade;
	private String sexo;
		
	
	//Getters and Setters
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	//Nétodos
	public void fazerReserva() {
		
	}
	
	public void cancelarReserva() {
		
	}
	
}

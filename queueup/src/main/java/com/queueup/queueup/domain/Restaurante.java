package com.queueup.queueup.domain;

public class Restaurante extends Usuario{
	
	public Restaurante(String nome) {
		super(nome);
		
	}
	
	
	//Atributos
	private Integer cnpj;
	private String endereco;
	private Mesa[] mesa;
	
	
	//Getters and Setters
	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Mesa[] getMesa() {
		return mesa;
	}

	public void setMesa(Mesa[] mesa) {
		this.mesa = mesa;
	}

	
	//Métodos
	public void cadastroMesa(int qtdLugares){
		
	}
	
	public void removerMesa(){
		
	}
	
	public void liberarMesa(){
		
	}
	
	public void bloquearMesa(){
		
	}
	
	public void editarMesa(){
		
	}
	
	
	
	

}

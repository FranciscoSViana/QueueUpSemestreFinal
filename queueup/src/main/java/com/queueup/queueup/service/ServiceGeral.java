package com.queueup.queueup.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.queueup.queueup.model.Usuario;

@Service
public class ServiceGeral {

	private final RestTemplate restTemplate;
	private final String url;
	
	public ServiceGeral() {
		restTemplate = new RestTemplate();
		url = "http://localhost:8081/usuarios";
	}
	
	public List<Usuario> cadastrarUsuario(String nome) {
		String nomeUsuario = url + "/criar";
		ResponseEntity<List> resposta = restTemplate.postForEntity(nomeUsuario, nome, List.class);
		return resposta.getBody();
	}

	public List<Usuario> logarUsuario(String login) {
		String loginUsuario = url + "/login" + login;
		ResponseEntity<Usuario[]> resposta = restTemplate.postForEntity(loginUsuario, login, Usuario[].class);
		return Arrays.asList(resposta.getBody());
	}
}

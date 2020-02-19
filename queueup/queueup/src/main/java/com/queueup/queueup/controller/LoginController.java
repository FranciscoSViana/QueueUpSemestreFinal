package com.queueup.queueup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {	
    @PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais, HttpSession session) {
    	// Faz select no banco puxando o login e senha
		if (credenciais.getLogin().equals(credenciais.getSenha())) {
			session.setAttribute("usuario", credenciais.getLogin());
			return ResponseEntity.ok("Sucesso");
			
		}
		else{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
			         .body("Erro");
		}
	}
    
    public ResponseEntity<String> deslogar(HttpSession session) {
    	session.invalidate();
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
		         .body("Erro"); 
    }

}
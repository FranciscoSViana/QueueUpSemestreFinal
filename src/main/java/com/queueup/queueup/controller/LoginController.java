package com.queueup.queueup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.queueup.queueup.dao.UsuarioRepository;
import com.queueup.queueup.model.Usuario;


@RestController
public class LoginController {
	
	private UsuarioRepository usuarioRepository;
   
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<String> efetuarLogin(@RequestBody Credenciais credenciais) {
		Usuario user = usuarioRepository.loginUsuario(credenciais);
		return user == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login/senha não conferem")
				: ResponseEntity.ok("Certo");

	}
    
    public ResponseEntity<String> deslogar(HttpSession session) {
    	session.invalidate();
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
		         .body("Erro"); 
    }

}

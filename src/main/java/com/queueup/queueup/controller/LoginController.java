package com.queueup.queueup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.queueup.queueup.dao.RestauranteRepository;
import com.queueup.queueup.dao.UsuarioRepository;
import com.queueup.queueup.model.Restaurante;
import com.queueup.queueup.model.Usuario;


@RestController
public class LoginController {
	
	private UsuarioRepository usuarioRepository;
   
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<String> efetuarLogin(@RequestBody Usuario usuarios) {
		Usuario user = usuarioRepository.loginUsuario(usuarios);
		return user == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login/senha não conferem")
				: ResponseEntity.ok("Certo");

	}
	
	private RestauranteRepository restauranteRepository;
    
    public ResponseEntity<String> deslogar(HttpSession session) {
    	session.invalidate();
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
		         .body("Erro"); 
    }
    
    @CrossOrigin
	@PostMapping("/login/restaurante")
	public ResponseEntity<String> efetuarLogin(@RequestBody Restaurante restaurantes) {
		Restaurante user = restauranteRepository.loginRestaurante(restaurantes);
		return user == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login/senha não conferem")
				: ResponseEntity.ok("Certo");

	}
    
    public ResponseEntity<String> deslogarRestaurante(HttpSession session) {
    	session.invalidate();
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
		         .body("Erro"); 
    }

}

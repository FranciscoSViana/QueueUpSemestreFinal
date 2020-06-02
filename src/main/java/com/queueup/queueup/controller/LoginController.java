package com.queueup.queueup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@Autowired
	public LoginController(UsuarioRepository usuarioRepository, RestauranteRepository restauranteRepository) {
		this.usuarioRepository = usuarioRepository;
		this.restauranteRepository = restauranteRepository;
	}

	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Usuario> efetuarLogin(@ModelAttribute Usuario usuarios) {
		Usuario user = usuarioRepository.loginUsuario(usuarios.getCpf(),usuarios.getSenha());
		System.out.println(user.getCpf());
		return user == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
				: ResponseEntity.status(HttpStatus.OK).body(user);

	}

	public ResponseEntity<String> deslogar(HttpSession session) {
		session.invalidate();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
	}

	private RestauranteRepository restauranteRepository;

	@CrossOrigin
	@PostMapping("/login/restaurante")
	public ResponseEntity<Restaurante> efetuarLogin(@ModelAttribute Restaurante restaurantes) {
		Restaurante user = restauranteRepository.loginRestaurante(restaurantes.getCnpj(),restaurantes.getSenha());
		System.out.println(user.getCnpj());
		return user == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
				: ResponseEntity.status(HttpStatus.OK).body(user);

	}

	public ResponseEntity<String> deslogarRestaurante(HttpSession session) {
		session.invalidate();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
	}

}

package com.queueup.queueup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.queueup.queueup.dao.UsuarioRepository;
import com.queueup.queueup.model.Usuario;
import com.queueup.queueup.utils.GravaArquivo;
import com.queueup.queueup.utils.ListaObj;

@RestController
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Usuario> efetuarLogin(@RequestBody Credenciais credenciais) {

		ListaObj<Credenciais> lista = new ListaObj<Credenciais>(1);
		lista.adiciona(credenciais);
		GravaArquivo.gravaArquivo(lista);
		
		Usuario user = usuarioRepository.loginUsuario(credenciais);
		return user == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).build() : 
			ResponseEntity.ok(user);

	}

	public ResponseEntity<String> deslogar(HttpSession session) {
		session.invalidate();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
	}

}

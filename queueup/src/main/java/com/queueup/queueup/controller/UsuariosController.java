package com.queueup.queueup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queueup.queueup.dao.UsuarioRepository;
import com.queueup.queueup.model.Usuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	private UsuarioRepository todosUsuarios;

	@Autowired
	public UsuariosController(UsuarioRepository todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

	private List<Usuario> usuarios;

	@CrossOrigin
	@PostMapping("/criar")
	public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
		System.out.println("alo");
		todosUsuarios.save(usuario);
		return ResponseEntity.ok("Sucesso");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") UUID id, @RequestBody Usuario usuario) {
		System.out.println("Atualizando usuario do ID = " + id + "...");

		Optional<Usuario> dadoUsuario = todosUsuarios.findById(id);

		if (dadoUsuario.isPresent()) {
			Usuario _usuario = dadoUsuario.get();
			_usuario.setTelefone(usuario.getTelefone());
			_usuario.setIdade(usuario.getIdade());
			_usuario.setCredenciais(usuario.getCredenciais());
			_usuario.setEmail(usuario.getEmail());
			return new ResponseEntity<>(todosUsuarios.save(_usuario), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome) {
		List<Usuario> usuariosEncontrados = new ArrayList<Usuario>();
		for (Usuario u : usuarios) {
			if (u.getNome().equals(nome)) {
				usuariosEncontrados.add(u);
			}
		}
		if (usuariosEncontrados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(usuariosEncontrados);
		}
	}

}

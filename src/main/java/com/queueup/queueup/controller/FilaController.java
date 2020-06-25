package com.queueup.queueup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queueup.queueup.dao.FilaRepository;
import com.queueup.queueup.dao.RestauranteRepository;
import com.queueup.queueup.model.Fila;
import com.queueup.queueup.model.Restaurante;
import com.queueup.queueup.model.Usuario;
import com.queueup.queueup.service.FilaService;
import com.queueup.queueup.utils.FilaCliente;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fila")
public class FilaController {

	@Autowired
	private FilaService service;

	@PostMapping("/entrar")
	public ResponseEntity<Integer> obterPosicaoFila(@RequestBody FilaCliente fila) {
		int posicao = service.addFila(fila);
		return ResponseEntity.ok(posicao);
	}

	@PostMapping("/remover/{restaurante}")
	public ResponseEntity<String> removerPosicao(@PathVariable("restaurante") Integer restaurante) {
		service.removefila(restaurante);
		return ResponseEntity.ok("Removido com sucesso!");
	}

	@GetMapping("/posicao/{restaurante}/{cliente}")
	public ResponseEntity<Integer> atualizaPosicao(@PathVariable("restaurante") Integer restaurante,
			@PathVariable("cliente") Integer cliente) {
		int posicao = service.posicaoFila(restaurante, cliente);
		return ResponseEntity.ok(posicao);
	}
	
	@GetMapping("/filaPorRestaurante/{idRestaurante}")
	public ResponseEntity<List<FilaCliente>> filaPorRestaurante(@PathVariable("idRestaurante") Integer idRestaurante) {
		return ResponseEntity.ok(service.getAll(idRestaurante));
	}
	
	@GetMapping("/filaTotalRestaurante/{idRestaurante}")
	public ResponseEntity<Integer> filaTotalRestaurante(@PathVariable("idRestaurante") Integer idRestaurante) {
		return ResponseEntity.ok(service.getAll(idRestaurante).size());
	}
}

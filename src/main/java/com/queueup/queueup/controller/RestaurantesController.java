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

import com.queueup.queueup.dao.RestauranteRepository;
import com.queueup.queueup.model.Restaurante;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/restaurantes")
public class RestaurantesController {

	private RestauranteRepository todosRestaurantes;

	@Autowired
	public RestaurantesController(RestauranteRepository todosRestaurantes) {
		this.todosRestaurantes = todosRestaurantes;
	}

	private List<Restaurante> restaurantes;

	@CrossOrigin
	@PostMapping("/criar")
	public ResponseEntity<String> cadastrarRestaurante(@RequestBody Restaurante restaurante) {
		System.out.println("alo");
		todosRestaurantes.save(restaurante);
		return ResponseEntity.ok("Sucesso");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Restaurante> updateRestaurante(@PathVariable("id") UUID id,
			@RequestBody Restaurante restaurante) {
		System.out.println("Atualizando usuario do ID = " + id + "...");

		Optional<Restaurante> dadoRestaurante = todosRestaurantes.findById(id);

		if (dadoRestaurante.isPresent()) {
			Restaurante _restaurante = dadoRestaurante.get();
			_restaurante.setCnpj(restaurante.getCnpj());
			_restaurante.setSenha(restaurante.getSenha());
			return new ResponseEntity<>(todosRestaurantes.save(_restaurante), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/nome/{nomeDoRestaurante}")
	public ResponseEntity<List<Restaurante>> obterPorNome1(@PathVariable("nomeDoRestaurante") String nome) {
		List<Restaurante> restaurantesEncontrados = new ArrayList<Restaurante>();
		for (Restaurante r : restaurantes) {
			if (r.getNome().equals(nome)) {
				restaurantesEncontrados.add(r);
			}
		}
		if (restaurantesEncontrados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(restaurantesEncontrados);
		}
	}

}
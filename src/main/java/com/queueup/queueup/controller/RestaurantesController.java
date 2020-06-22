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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queueup.queueup.dao.RestauranteRepository;
import com.queueup.queueup.model.Restaurante;
import com.queueup.queueup.service.RestauranteService;
import com.queueup.queueup.service.ServiceGeral;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/restaurantes")
public class RestaurantesController {

	@Autowired
	private RestauranteRepository todosRestaurantes;
	
	@Autowired
	private RestauranteService restauranteService;

	@Autowired
	private ServiceGeral serviceGeral;
	
	@Autowired
	public RestaurantesController(RestauranteRepository todosRestaurantes) {
		this.todosRestaurantes = todosRestaurantes;
	}

	private List<Restaurante> restaurantes;
	private List<Restaurante> tipoRestaurante;

	@CrossOrigin
	@PostMapping("/criar")
	public ResponseEntity<Restaurante> cadastrarRestaurante(@RequestBody Restaurante restaurante) {
		System.out.println("alo");
		todosRestaurantes.save(restaurante);
		return ResponseEntity.status(HttpStatus.OK).body(restaurante);
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

//	@GetMapping("/nome/{nomeDoRestaurante}")
//	public ResponseEntity<List<Restaurante>> obterPorNome(@PathVariable("nomeDoRestaurante") String nome) {
//		return new ResponseEntity<>(restauranteService.findByName(nome), HttpStatus.OK);
////		List<Restaurante> restaurantesEncontrados = new ArrayList<Restaurante>();
////		for (Restaurante r : restaurantes) {
////			if (r.getNome().equals(nome)) {
////				restaurantesEncontrados.add(r);
//			}
//		}
//		if (restaurantesEncontrados.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		} else {
//			return ResponseEntity.status(HttpStatus.OK).body(restaurantesEncontrados);
//		}
	//}

	@GetMapping("/especialidades")
	public ResponseEntity<List<Restaurante>> obterTodosTipos(){
		return new ResponseEntity<>(serviceGeral.findByAll(), HttpStatus.OK);
	}
	
	@GetMapping("/especialidades/{tipoDoRestaurante}")
	public ResponseEntity<List<Restaurante>> obterPorTipo(@PathVariable("tipoDoRestaurante") String tipo) {
//		List<Restaurante> tiposEncontrados = restauranteService.findByType();
//		System.out.println(tiposEncontrados);
		return new ResponseEntity<>(restauranteService.findByType(tipo), HttpStatus.OK);
//		if (tiposEncontrados.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		} else {
//			return ResponseEntity.status(HttpStatus.OK).body(tiposEncontrados);
//		}
	}
}
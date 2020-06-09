package com.queueup.queueup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queueup.queueup.dao.FilaRepository;
import com.queueup.queueup.model.Fila;
import com.queueup.queueup.model.Usuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filas")

public class FilaController {
	
	@Autowired
	private FilaRepository filaRepository;
	
	@GetMapping("/disponivel")
	public ResponseEntity<List<Fila>> list(@RequestBody Fila mesa){
		List<Fila> lista = filaRepository.mesaDisp();
		return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	}
	
	@GetMapping("/ocupada")
	public ResponseEntity<List<Fila>> listOcupada(@RequestBody Fila mesa){
		List<Fila> lista = filaRepository.mesaOcupada();
		return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	}
	
	@PutMapping("/ocupar")
	public ResponseEntity<Boolean> ocupa(@RequestBody Fila mesa){
		filaRepository.ocuparMesa(mesa.getIdFila());
		return ResponseEntity.ok(true);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<String> cadastrarUsuario(@RequestBody Fila mesa){
		System.out.println("alo");
		filaRepository.save(mesa);
		return ResponseEntity.ok("Sucesso");
	}
	
	@PutMapping("/desocupar")
	public ResponseEntity<Boolean> desocupa(@RequestBody Fila mesa){
		filaRepository.desocuparMesa(mesa.getIdFila());
		return ResponseEntity.ok(true);
	}

}	

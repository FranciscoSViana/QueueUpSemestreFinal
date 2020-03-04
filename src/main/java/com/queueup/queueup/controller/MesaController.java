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

import com.queueup.queueup.dao.MesaRepository;
import com.queueup.queueup.model.Mesa;
import com.queueup.queueup.model.Usuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mesas")

public class MesaController {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	@GetMapping("/disponivel")
	public ResponseEntity<List<Mesa>> list(@RequestBody Mesa mesa){
		List<Mesa> lista = mesaRepository.mesaDisp();
		return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	}
	
	@GetMapping("/ocupada")
	public ResponseEntity<List<Mesa>> listOcupada(@RequestBody Mesa mesa){
		List<Mesa> lista = mesaRepository.mesaOcupada();
		return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	}
	
	@PutMapping("/ocupar")
	public ResponseEntity<Boolean> ocupa(@RequestBody Mesa mesa){
		mesaRepository.ocuparMesa(mesa.getidMesa());
		return ResponseEntity.ok(true);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<String> cadastrarUsuario(@RequestBody Mesa mesa){
		System.out.println("alo");
		mesaRepository.save(mesa);
		return ResponseEntity.ok("Sucesso");
	}
	
	@PutMapping("/desocupar")
	public ResponseEntity<Boolean> desocupa(@RequestBody Mesa mesa){
		mesaRepository.desocuparMesa(mesa.getidMesa());
		return ResponseEntity.ok(true);
	}

}	

package com.queueup.queueup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queueup.queueup.dao.RestauranteRepository;
import com.queueup.queueup.model.Restaurante;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public List<Restaurante> findByType(String type) {
		return restauranteRepository.findByTipo(type);
	}

}

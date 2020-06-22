package com.queueup.queueup.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queueup.queueup.dao.RestauranteRepository;
import com.queueup.queueup.model.Restaurante;

@Service
public class ServiceGeral {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public List<Restaurante> findByAll() {
		return restauranteRepository.findAll();
	}
}

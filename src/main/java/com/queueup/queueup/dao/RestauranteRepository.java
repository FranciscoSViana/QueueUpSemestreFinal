package com.queueup.queueup.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.queueup.queueup.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> {

	@Query("from Restaurante where restaurante=:restaurante")
	public Restaurante loginRestaurante(@Param("restaurante") Restaurante restaurantes);

	//public Restaurante findByNome(String nome);

}

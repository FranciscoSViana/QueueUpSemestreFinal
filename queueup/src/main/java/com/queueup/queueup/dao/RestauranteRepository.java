package com.queueup.queueup.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.queueup.queueup.controller.Credenciais;
import com.queueup.queueup.model.Restaurante;
import com.queueup.queueup.model.Usuario;

public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> {

	@Query("select u from Usuario u where u.credenciais = :credenciais")
	public Restaurante loginRestaurante(@Param("credenciais") Credenciais credenciais);

	public Restaurante findByNome(String nome);
}

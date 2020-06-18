package com.queueup.queueup.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.queueup.queueup.model.Restaurante;
import com.queueup.queueup.model.Usuario;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> {

	@Query("select u from Restaurante u where u.cnpj = :cnpj and u.senha = :senha")
	public Restaurante loginRestaurante(@Param("cnpj") String cnpj, @Param("senha") String senha);
	
	public List<Restaurante> findByTipo(String tipo);

	//public Restaurante findByNome(String nome);

}

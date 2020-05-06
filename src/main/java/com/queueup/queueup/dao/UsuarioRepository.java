package com.queueup.queueup.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.queueup.queueup.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	@Query("from Usuario where usuario=:usuario")
	public Usuario loginUsuario(@Param("usuario") Usuario usuarios);

	public Usuario findByNome(String nome);

}

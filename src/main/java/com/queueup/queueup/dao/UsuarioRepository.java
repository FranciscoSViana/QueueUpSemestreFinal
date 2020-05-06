package com.queueup.queueup.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.queueup.queueup.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	@Query("select u from Usuario u where u.cpf = :cpf and u.senha = :senha")
	public Usuario loginUsuario(@Param("cpf") String cpf, @Param("senha") String senha);

}
